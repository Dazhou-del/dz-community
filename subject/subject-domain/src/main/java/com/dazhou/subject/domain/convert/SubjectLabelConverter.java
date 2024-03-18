package com.dazhou.subject.domain.convert;

import com.dazhou.subject.domain.entity.SubjectLabelBo;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:37
 */
@Mapper
public interface SubjectLabelConverter {
    SubjectLabelConverter INSTANCE= Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabelBo convertBoToLabel(SubjectLabel subjectLabel);
    SubjectLabel convertLabelToBo(SubjectLabelBo subjectLabelBo);

    List<SubjectLabelBo> convertBoToLabelList(List<SubjectLabel> subjectLabelList);




}
