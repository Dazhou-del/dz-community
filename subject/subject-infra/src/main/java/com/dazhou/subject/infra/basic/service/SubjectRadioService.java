package com.dazhou.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dazhou.subject.infra.basic.entity.SubjectRadio;

import java.util.List;


/**
* @author da zhou
* @description 针对表【subject_radio(单选题信息表)】的数据库操作Service
* @createDate 2024-03-18 22:32:45
*/
public interface SubjectRadioService extends IService<SubjectRadio> {

    List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio);
}
