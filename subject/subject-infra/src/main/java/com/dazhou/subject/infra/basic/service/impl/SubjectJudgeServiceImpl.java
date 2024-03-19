package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.SubjectJudge;
import generator.service.SubjectJudgeService;
import com.dazhou.subject.infra.basic.mapper.SubjectJudgeMapper;
import org.springframework.stereotype.Service;

/**
* @author da zhou
* @description 针对表【subject_judge(判断题)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:31
*/
@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge>
    implements SubjectJudgeService{

}




