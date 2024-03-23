package com.dazhou.subject.infra.basic.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.dazhou.subject.infra.basic.service.SubjectInfoService;
import com.dazhou.subject.infra.basic.mapper.SubjectInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
* @createDate 2024-03-17 21:33:46
*/
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
    implements SubjectInfoService{

    @Resource
    private SubjectInfoMapper subjectInfoMapper;


    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return subjectInfoMapper.countByCondition(subjectInfo,categoryId, labelId);
    }

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return subjectInfoMapper.queryPage( subjectInfo, categoryId, labelId, start, pageSize);
    }
}




