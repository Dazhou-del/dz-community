package com.dazhou.subject.domain.convert;

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
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE=Mappers.getMapper(SubjectCategoryConverter .class);

    SubjectCategory convertBoToCategory(SubjectCategoryBo subjectCategoryBo);

    List<SubjectCategoryBo> convertCategoryToBo(List<SubjectCategory> categoryList);

}
