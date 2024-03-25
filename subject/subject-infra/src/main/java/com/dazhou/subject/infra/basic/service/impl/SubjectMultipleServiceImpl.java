package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dazhou.subject.infra.basic.entity.SubjectMultiple;
import com.dazhou.subject.infra.basic.mapper.SubjectMultipleMapper;
import com.dazhou.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_multiple(多选题信息表)】的数据库操作Service实现
* @createDate 2024-03-18 22:32:41
*/
@Service
public class SubjectMultipleServiceImpl extends ServiceImpl<SubjectMultipleMapper, SubjectMultiple>
    implements SubjectMultipleService {

    @Resource
    private SubjectMultipleMapper subjectMultipleMapper;

    @Override
    public List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple) {
        return subjectMultipleMapper.queryAllByLimit(subjectMultiple);
    }
}




