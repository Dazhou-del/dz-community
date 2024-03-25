package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dazhou.subject.infra.basic.entity.SubjectJudge;
import com.dazhou.subject.infra.basic.mapper.SubjectJudgeMapper;
import com.dazhou.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_judge(判断题)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:31
*/
@Service
public class SubjectJudgeServiceImpl extends ServiceImpl<SubjectJudgeMapper, SubjectJudge>
    implements SubjectJudgeService {

    @Resource
    private SubjectJudgeMapper subjectJudgeMapper;

    @Override
    public List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge) {
        return  subjectJudgeMapper.queryAllByLimit(subjectJudge);
    }
}




