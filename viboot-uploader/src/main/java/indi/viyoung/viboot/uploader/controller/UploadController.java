package indi.viyoung.viboot.uploader.controller;

import indi.viyoung.viboot.uploader.service.IUploadService;
import indi.viyoung.viboot.uploader.vo.Chunk;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author vi
 * @since 2019/4/16 9:42 PM
 */
@RequestMapping("/upload")
@RestController
@Slf4j
@CrossOrigin
public class UploadController {

    private final static String CHUNK_FOLDER = "/Users/yangwei/resource/data/chunk";
    private final static String SINGLE_FOLDER = "/Users/yangwei/resource/data/single";

    @Autowired
    private IUploadService uploadService;


    @PostMapping("single")
    public void singleUpload(Chunk chunk) {
        MultipartFile file = chunk.getFile();
        String filename = chunk.getFilename();
        try {
            byte[] bytes = file.getBytes();
            if (!Files.isWritable(Paths.get(SINGLE_FOLDER))) {
                Files.createDirectories(Paths.get(SINGLE_FOLDER));
            }
            Path path = Paths.get(SINGLE_FOLDER,filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("chunk")
    public Map<String, Object> checkChunks(Chunk chunk) {
        return uploadService.checkChunkExits(chunk);
    }

    @PostMapping("chunk")
    public Map<String, Object> saveChunk(Chunk chunk) {
        MultipartFile file = chunk.getFile();
        Integer chunkNumber = chunk.getChunkNumber();
        String identifier = chunk.getIdentifier();
        byte[] bytes;
        try {
            bytes = file.getBytes();
            Path path = Paths.get(generatePath(CHUNK_FOLDER, chunk));
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer chunks = uploadService.saveChunk(chunkNumber, identifier);
        Map<String, Object> result = new HashMap<>();
        if (chunks.equals(chunk.getTotalChunks())) {
            result.put("message","上传成功！");
            result.put("code", 205);
        }
        return result;
    }

    @PostMapping("merge")
    public void mergeChunks(Chunk chunk) {
        String fileName = chunk.getFilename();
        uploadService.mergeFile(fileName,CHUNK_FOLDER + File.separator + chunk.getIdentifier());
    }

    private static String generatePath(String uploadFolder, Chunk chunk) {

        StringBuilder sb = new StringBuilder();
        sb.append(uploadFolder).append(File.separator).append(chunk.getIdentifier());
        //判断uploadFolder/identifier 路径是否存在，不存在则创建
        if (!Files.isWritable(Paths.get(sb.toString()))) {
            try {
                Files.createDirectories(Paths.get(sb.toString()));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return sb.append(File.separator)
                .append(chunk.getFilename())
                .append("-")
                .append(chunk.getChunkNumber()).toString();

    }
}
