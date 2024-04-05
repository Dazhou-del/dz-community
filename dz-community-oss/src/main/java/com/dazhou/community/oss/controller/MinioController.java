package com.dazhou.community.oss.controller;

import com.dazhou.community.oss.entity.FileInfo;
import com.dazhou.community.oss.util.MinioUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件controller
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-04-06 2:17
 */
@RestController
public class MinioController {

    @Resource
    private MinioUtil minioUtil;

    @RequestMapping("/getBucketAllFile")
    public List<FileInfo> getBucketAllFile() throws Exception {
        List<FileInfo> fileInfoList = minioUtil.getBucketAllFile("dazhou");
        return fileInfoList;
    }

    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() throws Exception {
        List<String> allBucket = minioUtil.getAllBucket();
        return allBucket.get(0);
    }
}
