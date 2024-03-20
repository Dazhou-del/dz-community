package com.dazhou.subject.infra.basic.mapper;

import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_label(题目标签表)】的数据库操作Mapper
* @createDate 2024-03-17 21:32:26
* @Entity com.dazhou.subject.infra.basic.entity.SubjectLabel
*/
public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {
    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);

    List<SubjectLabel> batchQueryById(@Param("list") List<Long> labelIdList);
}




