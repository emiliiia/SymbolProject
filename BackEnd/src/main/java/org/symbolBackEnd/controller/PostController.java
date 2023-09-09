package org.symbolBackEnd.controller;
/*
  @author emilia
  @project SymbolProject
  @class PostController
  @version 1.0.0
  @since 09.09.2023 - 12:20
*/

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.symbolBackEnd.dto.post.PostDTO;
import org.symbolBackEnd.dto.post.PostFormDTO;
import org.symbolBackEnd.service.fileStorage.FilesStorageServiceImpl;
import org.symbolBackEnd.service.post.PostServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RequestMapping(value = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    private final PostServiceImpl postService;
    private final FilesStorageServiceImpl fileService;

    public PostController(PostServiceImpl postService, FilesStorageServiceImpl fileService) {
        this.postService = postService;
        this.fileService = fileService;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody PostFormDTO postDTO) {
        return postService.create(postDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Integer id) throws IOException {
        postService.delete(id);
    }

    @PutMapping( "/update/")
    public void update(@RequestBody PostDTO postDTO) {
        postService.update(postDTO);
    }

    @PutMapping( "/updateWithPhoto/")
    public void updateWithPhoto(@RequestBody PostDTO postDTO) throws IOException {
        postService.updateWithPhoto(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO showOne(@PathVariable Integer id) {
        return postService.get(id);
    }

    @RequestMapping("/")
    List<PostDTO> showAll(){
        return postService.getAll();
    }


    @PostMapping("/uploadPhoto/")
    public void upload(@RequestPart MultipartFile photo, @RequestParam String newPath) throws IOException {
        fileService.save(photo, newPath);
    }
}
