package org.symbolBackEnd.service.post;
/*
  @author emilia
  @project SymbolProject
  @class PostServiceImpl
  @version 1.0.0
  @since 09.09.2023 - 12:05
*/

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.symbolBackEnd.dto.post.PostDTO;
import org.symbolBackEnd.dto.post.PostFormDTO;
import org.symbolBackEnd.entity.Post;
import org.symbolBackEnd.exception.DatabaseFetchException;
import org.symbolBackEnd.mapper.PostMapper;
import org.symbolBackEnd.repository.PostRepository;
import org.symbolBackEnd.service.fileStorage.FilesStorageServiceImpl;

import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    private PostRepository repository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private FilesStorageServiceImpl fileService;

    @Override
    public Integer create(PostFormDTO dto) {
        Post createdPost = postMapper.createToEntity(new Post(), dto);
        return repository.save(createdPost).getId();
    }

    @Override
    public void delete(Integer id) throws IOException {
        fileService.delete("PostImage/post_" + id + ".jpg");
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
        fileService.delete("PostImage/post_" + dto.getId() + ".jpg");
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
}
