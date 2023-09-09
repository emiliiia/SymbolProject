package org.symbolBackEnd.service.fileStorage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFilesStorageService {
    void save(MultipartFile file, String path) throws IOException;
    void delete(String filePath) throws IOException;
    void move(String oldPath, String newPath) throws IOException;
    boolean exists(String path);
    void saveOrReplace(MultipartFile file, String path) throws IOException;
}
