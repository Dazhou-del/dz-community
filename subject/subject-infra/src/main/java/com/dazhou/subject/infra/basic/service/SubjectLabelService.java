package com.dazhou.subject.infra.basic.service;

import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_label(题目标签表)】的数据库操作Service
* @createDate 2024-03-17 21:32:26
*/

public interface SubjectLabelService extends IService<SubjectLabel> {

    /**
     * 新增标签
     * @param subjectLabel
     */
    void insert(SubjectLabel subjectLabel);

    /**
     * 根据分类查询标签
     * @param subjectLabel
     */
    List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel);


    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);


    List<SubjectLabel> batchQueryById(List<Long> labelIdList);
}
