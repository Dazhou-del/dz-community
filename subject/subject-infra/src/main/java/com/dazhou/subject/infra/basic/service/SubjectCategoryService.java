package com.dazhou.subject.infra.basic.service;

import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_category(题目分类)】的数据库操作Service
* @createDate 2024-03-14 23:17:45
*/
public interface SubjectCategoryService extends IService<SubjectCategory> {

    void insert(SubjectCategory subjectCategory);

    void update(SubjectCategory subjectCategory);

    /**
     * 根据条件查询分类
     * @param subjectCategory
     * @return
     */
    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

    /**
     * 统计分类下有多少个标签
     * @param id
     * @return
     */
    Integer querySubjectCount(Long id);


    SubjectCategory queryByCategoryId(Long categoryId);
}
