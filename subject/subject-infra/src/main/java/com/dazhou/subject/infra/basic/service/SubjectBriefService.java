package com.dazhou.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhou.subject.infra.basic.entity.SubjectBrief;


/**
* @author da zhou
* @description 针对表【subject_brief(简答题)】的数据库操作Service
* @createDate 2024-03-18 22:32:04
*/
public interface SubjectBriefService extends IService<SubjectBrief> {

    /**
     * 查询指定行记录
     * @param subjectBrief
     * @return
     */
    SubjectBrief queryByCondition(SubjectBrief subjectBrief);
}
