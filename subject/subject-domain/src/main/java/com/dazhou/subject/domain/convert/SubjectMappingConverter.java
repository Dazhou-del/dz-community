package com.dazhou.subject.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-20 21:06
 */
@Mapper
public interface SubjectMappingConverter {
    SubjectMappingConverter INSTANCE= Mappers.getMapper(SubjectMappingConverter.class);


}
