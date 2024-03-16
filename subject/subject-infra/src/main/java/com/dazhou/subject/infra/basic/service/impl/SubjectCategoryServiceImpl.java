package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.dazhou.subject.infra.basic.service.SubjectCategoryService;
import com.dazhou.subject.infra.basic.mapper.SubjectCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author da zhou
* @description 针对表【subject_category(题目分类)】的数据库操作Service实现
* @createDate 2024-03-14 23:17:45
*/
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory>
    implements SubjectCategoryService{

    @Resource
    private SubjectCategoryMapper subjectCategoryMapper;
    @Override
    public void insert(SubjectCategory subjectCategory) {
        subjectCategoryMapper.insert(subjectCategory);
    }
}




