package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SubjectMapping;
import generator.service.SubjectMappingService;
import com.dazhou.subject.infra.basic.mapper.SubjectMappingMapper;
import org.springframework.stereotype.Service;

/**
* @author da zhou
* @description 针对表【subject_mapping(题目分类关系表)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:57
*/
@Service
public class SubjectMappingServiceImpl extends ServiceImpl<SubjectMappingMapper, SubjectMapping>
    implements SubjectMappingService{

}




