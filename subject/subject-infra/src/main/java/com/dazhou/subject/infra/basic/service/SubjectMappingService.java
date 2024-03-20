package com.dazhou.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service
* @createDate 2024-03-18 22:32:57
*/
public interface SubjectMappingService extends IService<SubjectMapping> {
    /**
     * 查询标签id
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);
}
