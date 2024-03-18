package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.dazhou.subject.infra.basic.service.SubjectLabelService;
import com.dazhou.subject.infra.basic.mapper.SubjectLabelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_label(题目标签表)】的数据库操作Service实现
* @createDate 2024-03-17 21:32:26
*/
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel>
    implements SubjectLabelService{

    @Resource
    private SubjectLabelMapper subjectLabelMapper;
    @Override
    public void insert(SubjectLabel subjectLabel) {
        subjectLabelMapper.insert(subjectLabel);
    }

    @Override
    public List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel) {
        LambdaQueryWrapper<SubjectLabel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SubjectLabel::getCategoryId,subjectLabel.getCategoryId());
        return subjectLabelMapper.selectList(queryWrapper);
    }


}




