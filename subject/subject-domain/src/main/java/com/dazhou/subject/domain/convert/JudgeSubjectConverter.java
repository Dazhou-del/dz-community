package com.dazhou.subject.domain.convert;

import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.infra.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-25 0:01
 */
@Mapper
public interface JudgeSubjectConverter {
    JudgeSubjectConverter INSTANCE = Mappers.getMapper(JudgeSubjectConverter.class);

    List<SubjectAnswerBo> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);
}
