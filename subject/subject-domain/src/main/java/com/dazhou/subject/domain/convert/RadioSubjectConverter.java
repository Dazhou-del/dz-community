package com.dazhou.subject.domain.convert;

import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:29
 */
@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE=Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio convertBoToRadio(SubjectAnswerBo subjectAnswerBo);
}
