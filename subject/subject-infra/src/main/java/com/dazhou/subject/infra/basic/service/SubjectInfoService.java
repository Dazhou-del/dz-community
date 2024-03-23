package com.dazhou.subject.infra.basic.service;

import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_info(题目信息表)】的数据库操作Service
* @createDate 2024-03-17 21:33:46
*/
public interface SubjectInfoService extends IService<SubjectInfo> {



    /**
     * 根据题目条件查询总数量
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @return
     */
    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);
}
