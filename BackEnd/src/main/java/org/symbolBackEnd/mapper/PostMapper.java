package org.symbolBackEnd.mapper;
/*
  @author emilia
  @project SymbolProject
  @class PostMapper
  @version 1.0.0
  @since 05.09.2023 - 20:52
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.symbolBackEnd.dto.post.PostDTO;
import org.symbolBackEnd.dto.post.PostFormDTO;
import org.symbolBackEnd.dto.post.PostListDTO;
import org.symbolBackEnd.entity.Post;
import org.symbolBackEnd.entity.User;
import org.symbolBackEnd.repository.PostRepository;
import org.symbolBackEnd.repository.UserRepository;


import java.time.LocalDateTime;

@Component
public class PostMapper {

    @Autowired
    private UserRepository userRepository;

    public PostDTO toPostDto(Post entity) {
        PostDTO dto = new PostDTO();


        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setForeword(entity.getForeword());
        dto.setContent(entity.getContent());
        dto.setPublishedAt(entity.getPublishedAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public Post toEntity(Post entity, PostDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setForeword(dto.getForeword());

        if(dto.getContent().contains("&#")){
            StringBuilder newStr = new StringBuilder(dto.getContent().replace(";", "&#"));

            String[] text = newStr.toString().split("&#");

            newStr = new StringBuilder();
            for (String s : text) {
                if(s.length() <= 4 && s.matches("[-+]?\\d+")){
                    int m = Integer.parseInt(s, 10);
                    newStr.append(Character.toString(m));
                }
                else {
                    newStr.append(s);
                }
            }

            entity.setContent(String.valueOf(newStr));
        }
        else {
            entity.setContent(dto.getContent());
        }

        entity.setAuthor(userRepository.getReferenceById(1));
        entity.setPublishedAt(dto.getPublishedAt());

        return entity;
    }

    public PostListDTO toPostListDto(Post entity) {
        PostListDTO listDTO = new PostListDTO();
        listDTO.setId(entity.getId());
        listDTO.setTitle(entity.getTitle());
        listDTO.setForeword(entity.getForeword());
        listDTO.setPublishedAt(entity.getPublishedAt());

        return listDTO;
    }

    public Post createToEntity(Post entity, PostFormDTO dto) {

        entity.setTitle(dto.getTitle());
        entity.setForeword(dto.getForeword());

        if(dto.getContent().contains("&#")){
            StringBuilder newStr = new StringBuilder(dto.getContent().replace(";", "&#"));

            String[] text = newStr.toString().split("&#");

            newStr = new StringBuilder();
            for (String s : text) {
                if(s.length() <= 4 && s.matches("[-+]?\\d+")){
                    int m = Integer.parseInt(s, 10);
                    newStr.append(Character.toString(m));
                }
                else {
                    newStr.append(s);
                }
            }

            entity.setContent(String.valueOf(newStr));
        }
        else {
            entity.setContent(dto.getContent());
        }

        entity.setAuthor(userRepository.getReferenceById(1));
        entity.setPublishedAt(LocalDateTime.now());
        return entity;
    }


}
