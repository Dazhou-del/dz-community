package com.dazhou.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Mapper
* @createDate 2024-03-18 22:32:57
* @Entity generator.domain.SubjectMapping
*/
public interface SubjectMappingMapper extends BaseMapper<SubjectMapping> {
    List<SubjectMapping> queryDistinctLabelId(SubjectMapping subjectMapping);

}




