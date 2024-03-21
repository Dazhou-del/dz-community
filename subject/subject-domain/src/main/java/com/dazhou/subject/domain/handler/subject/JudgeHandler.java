package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;
import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.infra.basic.entity.SubjectJudge;
import com.dazhou.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 判断题handler
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:13
 */
@Component
public class JudgeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectInfoTypeEnum getHandler() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void addSubject(SubjectInfoBo subjectInfoBo) {
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBo subjectAnswerBO = subjectInfoBo.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBo.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudgeService.save(subjectJudge);
    }

}
