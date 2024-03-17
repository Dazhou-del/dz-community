package com.dazhou.subject.infra.basic.service;

import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author da zhou
* @description 针对表【subject_category(题目分类)】的数据库操作Service
* @createDate 2024-03-14 23:17:45
*/
public interface SubjectCategoryService extends IService<SubjectCategory> {

    void insert(SubjectCategory subjectCategory);

    void update(SubjectCategory subjectCategory);
}
