package org.symbolBackEnd.service.post;

import org.symbolBackEnd.dto.post.PostDTO;
import org.symbolBackEnd.dto.post.PostFormDTO;

import java.io.IOException;
import java.util.List;

public interface IPostService {
    Integer create(PostFormDTO dto);
    void delete(Integer id) throws IOException;
    void update(PostDTO dto);
    void updateWithPhoto(PostDTO dto) throws IOException;
    PostDTO get(Integer id);
    List<PostDTO> getAll();
}
