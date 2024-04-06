package com.dazhou.community.oss.service;

import com.dazhou.community.oss.adapter.StorageAdapter;
import com.dazhou.community.oss.entity.FileInfo;
import io.minio.ListObjectsArgs;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 文件存储Service
 *
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 16:17
 */
@Service
public class FileService {

    private final StorageAdapter storageAdapter;

    public FileService(StorageAdapter storageAdapter){
        this.storageAdapter=storageAdapter;
    }


    /**
     * 获取所有桶
     *
     * @return
     * @throws Exception
     */
    public List<String> getAllBucket(){
        return storageAdapter.getAllBucket();
    }

    /**
     * 获取桶下的所有文件
     */
    public List<FileInfo> getBucketAllFile(String bucketName) throws Exception {
        return storageAdapter.getBucketAllFile(bucketName);
    }
}
