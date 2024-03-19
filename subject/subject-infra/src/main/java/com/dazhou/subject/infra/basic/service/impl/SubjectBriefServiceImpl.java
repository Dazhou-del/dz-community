package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SubjectBrief;
import generator.service.SubjectBriefService;
import com.dazhou.subject.infra.basic.mapper.SubjectBriefMapper;
import org.springframework.stereotype.Service;

/**
* @author da zhou
* @description 针对表【subject_brief(简答题)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:04
*/
@Service
public class SubjectBriefServiceImpl extends ServiceImpl<SubjectBriefMapper, SubjectBrief>
    implements SubjectBriefService{

}




