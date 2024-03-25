package com.dazhou.subject.domain.convert;

import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 11:05
 */
@Mapper
public interface MultipleSubjectConverter {

    MultipleSubjectConverter INSTANCE= Mappers.getMapper(MultipleSubjectConverter.class);

    SubjectMultiple convertBotoMultiple(SubjectAnswerBo subjectAnswerBo);

    List<SubjectAnswerBo> convertEntityToBoList(List<SubjectMultiple> subjectMultipleList);
}
