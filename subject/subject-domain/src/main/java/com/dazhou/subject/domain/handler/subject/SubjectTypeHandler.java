package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;
import com.dazhou.subject.domain.entity.SubjectInfoBo;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:07
 */
public interface SubjectTypeHandler {

    /**
     * 枚举身份识别
     * @return
     */
    SubjectInfoTypeEnum getHandler();

    /**
     * 插入题目
     * @param subjectInfoBo
     */
    void addSubject(SubjectInfoBo subjectInfoBo);
}
