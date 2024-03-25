package com.dazhou.subject.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dazhou.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Mapper
* @createDate 2024-03-18 22:32:41
* @Entity generator.domain.SubjectMultiple
*/
public interface SubjectMultipleMapper extends BaseMapper<SubjectMultiple> {

    List<SubjectMultiple> queryAllByLimit(SubjectMultiple subjectMultiple);
}




