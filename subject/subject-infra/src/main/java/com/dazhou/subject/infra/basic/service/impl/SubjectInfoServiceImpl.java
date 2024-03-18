package com.dazhou.subject.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.dazhou.subject.infra.basic.service.SubjectInfoService;
import com.dazhou.subject.infra.basic.mapper.SubjectInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author da zhou
* @description 针对表【subject_info(题目信息表)】的数据库操作Service实现
* @createDate 2024-03-17 21:33:46
*/
@Service
public class SubjectInfoServiceImpl extends ServiceImpl<SubjectInfoMapper, SubjectInfo>
    implements SubjectInfoService{

}




