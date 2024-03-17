package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.dazhou.subject.infra.basic.service.SubjectLabelService;
import com.dazhou.subject.infra.basic.mapper.SubjectLabelMapper;
import org.springframework.stereotype.Service;

/**
* @author da zhou
* @description 针对表【subject_label(题目标签表)】的数据库操作Service实现
* @createDate 2024-03-17 21:32:26
*/
@Service
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel>
    implements SubjectLabelService{

}




