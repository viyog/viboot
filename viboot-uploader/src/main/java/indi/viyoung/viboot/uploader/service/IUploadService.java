package indi.viyoung.viboot.uploader.service;

import indi.viyoung.viboot.uploader.vo.Chunk;

import java.util.Map;

/**
 * @author vi
 * @since 2019/5/9 8:36 PM
 */
public interface IUploadService {

    Map<String, Object> checkChunkExits(Chunk chunk);

    Integer saveChunk(Integer chunkNumber, String identifier);

    void mergeFile(String fileName, String chunkFolder);
}
