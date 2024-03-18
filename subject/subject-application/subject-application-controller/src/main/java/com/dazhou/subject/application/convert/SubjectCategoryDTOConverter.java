package com.dazhou.subject.application.convert;

import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:46
 */
@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE=Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBo convertBoToCategory(SubjectCategoryDto subjectCategoryDto);

    List<SubjectCategoryDto> convertBoToCategoryDTOList(List<SubjectCategoryBo> subjectCategoryBoList);

    SubjectCategoryBo convertDtoToCategoryBO(SubjectCategoryDto subjectCategoryDTO);

    SubjectCategoryDto convertBoToCategoryDTO(SubjectCategoryDto subjectCategoryBO);

}
