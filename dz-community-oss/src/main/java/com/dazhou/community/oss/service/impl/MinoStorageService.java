package com.dazhou.community.oss.service.impl;

import com.dazhou.community.oss.entity.FileInfo;
import com.dazhou.community.oss.service.StorageService;
import com.dazhou.community.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * MinioOSS
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 3:00
 */
@Service("minoStorageService")
public class MinoStorageService implements StorageService {

    @Resource
    private MinioUtil minioUtil;

    @Override
    @SneakyThrows
    public void createBucket(String bucketName) {
        minioUtil.createBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public void deleteBucket(String bucketName) {
        minioUtil.deleteBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) {
        minioUtil.createBucket(bucketName);
        if (objectName != null) {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucketName
                    , objectName + "/" + uploadFile.getOriginalFilename());
        } else {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucketName,
                    uploadFile.getOriginalFilename());
        }
    }

    @Override
    @SneakyThrows
    public void deleteFile(String bucketName, String objectName) {
        minioUtil.deleteFile(bucketName, objectName);
    }

    @Override
    @SneakyThrows
    public List<String> getAllBucket() {
        List<String> allBucket = minioUtil.getAllBucket();
        return allBucket;
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getBucketAllFile(String bucketName) {
        return minioUtil.getBucketAllFile(bucketName);
    }

    @Override
    @SneakyThrows
    public InputStream download(String bucketName, String objectName) {
        return minioUtil.download(bucketName, objectName);
    }

    @Override
    @SneakyThrows
    public String getPreviewFileUrl(String bucketName, String objectName) {
        return minioUtil.getPreviewFileUrl(bucketName, objectName);
    }
}
