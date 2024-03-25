package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;
import com.dazhou.subject.domain.convert.BriefSubjectConverter;
import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.entity.SubjectOptionBO;
import com.dazhou.subject.infra.basic.entity.SubjectBrief;
import com.dazhou.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 简答题handler
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:13
 */
@Component
public class BriefHandler implements SubjectTypeHandler{
    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandler() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void addSubject(SubjectInfoBo subjectInfoBo) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBo);
        SubjectAnswerBo subjectAnswerBo = subjectInfoBo.getOptionList().get(0);
        subjectBrief.setSubjectAnswer(subjectAnswerBo.getOptionContent());
        subjectBrief.setSubjectId(subjectInfoBo.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.save(subjectBrief);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(Long.valueOf(subjectId));
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
