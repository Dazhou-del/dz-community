package com.dazhou.subject.application.convert;

import com.dazhou.subject.application.dto.SubjectAnswerDto;
import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.application.dto.SubjectInfoDto;
import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:46
 */
@Mapper
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE=Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoDto convertBoToInfo(SubjectInfoBo subjectInfoBo);

    SubjectInfoBo convertToBo(SubjectInfoDto subjectInfoDto);
    List<SubjectAnswerBo> convertListToBoInfo(List<SubjectAnswerDto> subjectInfoDto);



}
