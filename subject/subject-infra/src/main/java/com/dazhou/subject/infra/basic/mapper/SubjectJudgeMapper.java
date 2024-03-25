package com.dazhou.subject.infra.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dazhou.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_judge(判断题)】的数据库操作Mapper
* @createDate 2024-03-18 22:32:31
* @Entity generator.domain.SubjectJudge
*/
public interface SubjectJudgeMapper extends BaseMapper<SubjectJudge> {

    List<SubjectJudge> queryAllByLimit(SubjectJudge subjectJudge);
}




