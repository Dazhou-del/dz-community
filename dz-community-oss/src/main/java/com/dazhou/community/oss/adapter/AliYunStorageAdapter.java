package com.dazhou.community.oss.adapter;

import com.dazhou.community.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 阿里云OSS实现
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 3:01
 */

public class AliYunStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucketName) {

    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) {

    }

    @Override
    public void deleteFile(String bucketName, String objectName) {

    }

    @Override
    public List<String> getAllBucket() {
        List<String> stringList = new ArrayList<>();
        stringList.add("阿里云");
        return stringList;
    }

    @Override
    public List<FileInfo> getBucketAllFile(String bucketName) {
        return null;
    }

    @Override
    public InputStream download(String bucketName, String objectName) {
        return null;
    }

    @Override
    public String getPreviewFileUrl(String bucketName, String objectName) {
        return null;
    }
}
