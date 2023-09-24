package org.symbolBackEnd.service.post;
/*
  @author emilia
  @project SymbolProject
  @class PostServiceImpl
  @version 1.0.0
  @since 09.09.2023 - 12:05
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.symbolBackEnd.dto.PageDTO;
import org.symbolBackEnd.dto.post.PostDTO;
import org.symbolBackEnd.dto.post.PostFormDTO;
import org.symbolBackEnd.dto.post.PostListDTO;
import org.symbolBackEnd.dto.search.PostSearch;
import org.symbolBackEnd.dto.search.SearchDTO;
import org.symbolBackEnd.entity.Post;
import org.symbolBackEnd.exception.DatabaseFetchException;
import org.symbolBackEnd.mapper.PostMapper;
import org.symbolBackEnd.repository.PostRepository;
import org.symbolBackEnd.service.fileStorage.FilesStorageServiceImpl;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    private PostRepository repository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private FilesStorageServiceImpl fileService;

    private final EntityManager entityManager;

    public PostServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Integer create(PostFormDTO dto) {
        Post createdPost = postMapper.createToEntity(new Post(), dto);
        return repository.save(createdPost).getId();
    }

    @Override
    public void delete(Integer id) throws IOException {
        fileService.delete("images/image" + id + ".jpg");
        repository.deleteById(id);
    }

    @Override
    public void update(PostDTO dto) {
        Post postToUpdate = repository.findById(dto.getId()).orElseThrow(() -> new DatabaseFetchException("Could not find Post entity with id " + dto.getId()));
        Post updatedPost = postMapper.toEntity(postToUpdate, dto);
        repository.save(updatedPost);
    }

    @Override
    public void updateWithPhoto(PostDTO dto) throws IOException {
        Post postToUpdate = repository.findById(dto.getId()).orElseThrow(() -> new DatabaseFetchException("Could not find Post entity with id " + dto.getId()));
        Post updatedProduct = postMapper.toEntity(postToUpdate, dto);
        fileService.delete("images/image" + dto.getId() + ".jpg");
        repository.save(updatedProduct);
    }

    @Override
    public PostDTO get(Integer id) {
        return repository.findById(id).map(postMapper::toPostDto).orElseThrow(() -> new DatabaseFetchException("Could not find Post entity with id " + id));
    }

    @Override
    public List<PostDTO> getAll() {
        return repository.findAll().stream().map(postMapper::toPostDto).toList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageDTO<PostListDTO> getPage(SearchDTO<PostSearch> searchPostDTO) {
        List<PostListDTO> postDTOS = new ArrayList<>();
        for (Object entity : entityManager.createNativeQuery(getPageQuery(searchPostDTO), Post.class).getResultList()) {
            postDTOS.add(postMapper.toPostListDto((Post) entity));
        }
        Page<PostListDTO> page = new PageImpl<>(postDTOS);
        PageDTO<PostListDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(page.getContent());
        pageDTO.setTotalItem(((BigInteger) entityManager.createNativeQuery(getCountQuery(searchPostDTO)).getSingleResult()).longValue());
        return pageDTO;
    }

    /**
     * Для реалізації, пагінації, в даному випадку я використав Native Query, через те що треба було реалізувати,
     * fullTextSearch. Hibernate Search я не зміг використати через те, що він використовує свій тип предикати, який
     * не піддходе для реалізаціх пагінвції через репозиторій. Також у criteriaBuilder немає відповідної функції, яка б
     * повернула потрібну предикату. Чому не я зміг реалізувати свою предикату дивіться нижче.
     *
     */

    private String getPageQuery(SearchDTO<PostSearch> search) {
        StringBuilder query = new StringBuilder();
        PostSearch searchPattern = new PostSearch();
        if (search.getSearchPattern() != null) {
            searchPattern = search.getSearchPattern();
        }

        query.append("SELECT * FROM post p");
        if (searchPattern != null && searchPattern.getSearch() != null) {
            query.append(" WHERE p.title LIKE '%").append(searchPattern.getSearch()).append("%' " +
                    "OR p.content LIKE '%").append(searchPattern.getSearch()).append("%' ");
            if (search.getSortDirection() != null && search.getSortField() != null) {
                query.append(" ORDER BY p.").append(search.getSortField()).append(" ").append(search.getSortDirection());
            }
        }
        if (search.getPage() != null && search.getPageSize() != null) {
            query.append(" limit ").append(search.getPageSize()).append(" offset ").append(search.getPage() * search.getPageSize());
        }

        return query.toString();
    }
    private String getCountQuery(SearchDTO<PostSearch> search) {
        return "SELECT count(*) FROM post p";
    }

}