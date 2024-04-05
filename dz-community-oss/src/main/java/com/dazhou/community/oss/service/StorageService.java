package com.dazhou.community.oss.service;

import com.dazhou.community.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * OSS统一接口
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 2:57
 */
public interface StorageService {
    /**
     * 创建桶
     *
     * @param bucketName
     * @throws Exception
     */
    public void createBucket(String bucketName);


    /**
     * 删除桶
     *
     * @param bucketName
     * @throws Exception
     */
     void deleteBucket(String bucketName);

    /**
     * 上传文件
     *
     * @param uploadFile 输入流
     * @param bucketName  桶的名称
     * @param objectName  文件名称
     * @throws Exception
     */
     void uploadFile(MultipartFile uploadFile, String bucketName, String objectName);


    /**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
     void deleteFile(String bucketName, String objectName);

    /**
     * 获取所有桶
     *
     * @return
     * @throws Exception
     */
     List<String> getAllBucket();

    /**
     * 获取桶下的所有文件
     *
     * @param bucketName
     * @return
     * @throws Exception
     */
     List<FileInfo> getBucketAllFile(String bucketName);

    /**
     * 下载文件
     *
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
     InputStream download(String bucketName, String objectName);

    /**
     * 获取文件url
     *
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
     String getPreviewFileUrl(String bucketName, String objectName);
}
