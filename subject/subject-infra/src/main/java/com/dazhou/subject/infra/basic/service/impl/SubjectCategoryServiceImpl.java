package com.dazhou.subject.infra.basic.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.dazhou.subject.infra.basic.service.SubjectCategoryService;
import com.dazhou.subject.infra.basic.mapper.SubjectCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public void update(SubjectCategory subjectCategory) {
        subjectCategoryMapper.updateById(subjectCategory);
    }

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryMapper.queryAll(subjectCategory);
    }

    @Override
    public Integer querySubjectCount(Long id) {
        return subjectCategoryMapper.querySubjectCount(id);
    }
}




