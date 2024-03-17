package com.dazhou.subject.infra.basic.mapper;

import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_category(题目分类)】的数据库操作Mapper
* @createDate 2024-03-14 23:17:45
* @Entity com.dazhou.subject.infra.basic.entity.SubjectCategory
*/
public interface SubjectCategoryMapper extends BaseMapper<SubjectCategory> {

    List<SubjectCategory> queryAll(SubjectCategory subjectCategory);

    Integer querySubjectCount(Long id);

}




