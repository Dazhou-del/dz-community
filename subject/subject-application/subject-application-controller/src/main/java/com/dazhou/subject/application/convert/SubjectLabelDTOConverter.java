package com.dazhou.subject.application.convert;

import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.application.dto.SubjectInfoDto;
import com.dazhou.subject.application.dto.SubjectLabelDto;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.entity.SubjectLabelBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:46
 */
@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE=Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelDto convertBoToInfoDto(SubjectLabelBo subjectLabelBo);

    SubjectLabelBo convertDoToInfoBo(SubjectLabelDto subjectLabelDto);

    List<SubjectLabelDto> convertBoToInfoDtoList(List<SubjectLabelBo> subjectLabelBos);

}
