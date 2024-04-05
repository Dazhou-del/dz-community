package com.dazhou.community.oss.util;

import com.dazhou.community.oss.entity.FileInfo;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mino工具类
 *
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 1:41
 */
@Component
public class MinioUtil {
    @Resource
    private MinioClient minioClient;

    /**
     * 创建桶
     *
     * @param bucketName
     * @throws Exception
     */
    public void createBucket(String bucketName) throws Exception {
        //创建前判断桶是否存在
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exists) {
            //不存在则创建
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 删除桶
     *
     * @param bucketName
     * @throws Exception
     */
    public void deleteBucket(String bucketName) throws Exception {
        //创建前判断桶是否存在
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (exists) {
            //存在则删除
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 上传文件
     *
     * @param inputStream 输入流
     * @param bucketName  桶的名称
     * @param objectName  文件名称
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String bucketName, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
                .stream(inputStream, -1, 5242889L).build());
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    public void deleteFile(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取所有桶
     *
     * @return
     * @throws Exception
     */
    public List<String> getAllBucket() throws Exception {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.stream().map(Bucket::name).collect(Collectors.toList());

    }

    /**
     * 获取桶下的所有文件
     *
     * @param bucketName
     * @return
     * @throws Exception
     */
    public List<FileInfo> getBucketAllFile(String bucketName) throws Exception {
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new LinkedList<>();
        for (Result<Item> result : results) {
            FileInfo fileInfo = new FileInfo();
            Item item = result.get();
            fileInfo.setFileName(item.objectName());
            fileInfo.setDirectoryFlag(item.isDir());
            fileInfo.setEtag(item.etag());
            fileInfoList.add(fileInfo);
        }
        return fileInfoList;
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
    public InputStream download(String bucketName, String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder()
                .bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取文件url
     *
     * @param bucketName
     * @param objectName
     * @return
     * @throws Exception
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception {
        GetPresignedObjectUrlArgs results = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(results);
    }
}
