package com.dazhou.subject.domain.service;

import com.dazhou.subject.domain.entity.SubjectInfoBo;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:42
 */
public interface SubjectInfoDomainService {
    /**
     * 新增题目
     * @param subjectInfoBo
     */
    void add(SubjectInfoBo subjectInfoBo);
}