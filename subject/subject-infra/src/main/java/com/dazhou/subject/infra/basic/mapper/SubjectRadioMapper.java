package com.dazhou.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dazhou.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Mapper
* @createDate 2024-03-18 22:32:45
* @Entity generator.domain.SubjectRadio
*/
public interface SubjectRadioMapper extends BaseMapper<SubjectRadio> {

    List<SubjectRadio> queryAllByLimit(SubjectRadio subjectRadio);
}




