package com.dazhou.subject.domain.convert;

import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.entity.SubjectLabelBo;
import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:37
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE= Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo convertBotoInfo(SubjectInfoBo subjectInfoBo);



}
