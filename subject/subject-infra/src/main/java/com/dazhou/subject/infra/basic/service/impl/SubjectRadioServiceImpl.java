package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dazhou.subject.infra.basic.entity.SubjectRadio;
import com.dazhou.subject.infra.basic.mapper.SubjectRadioMapper;
import com.dazhou.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:45
*/
@Service
public class SubjectRadioServiceImpl extends ServiceImpl<SubjectRadioMapper, SubjectRadio>
    implements SubjectRadioService {

    @Resource
    private SubjectRadioMapper subjectRadioMapper;

    @Override
    public List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio) {
        return subjectRadioMapper.queryAllByLimit(subjectRadio);
    }
}




