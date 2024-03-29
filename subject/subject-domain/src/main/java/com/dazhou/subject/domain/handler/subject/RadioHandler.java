package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;
import com.dazhou.subject.domain.convert.RadioSubjectConverter;
import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.entity.SubjectOptionBO;
import com.dazhou.subject.infra.basic.entity.SubjectRadio;
import com.dazhou.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题Handler
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:09
 */
@Component
public class RadioHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioServicel;

    @Override
    public SubjectInfoTypeEnum getHandler() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void addSubject(SubjectInfoBo subjectInfoBo) {
        List<SubjectRadio> subjectRadios=new LinkedList<>();
        subjectInfoBo.getOptionList().forEach(subjectAnswerBo -> {
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToRadio(subjectAnswerBo);
            subjectRadio.setSubjectId(subjectInfoBo.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioServicel.save(subjectRadio);
        });
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioServicel.queryByCondition(subjectRadio);
        List<SubjectAnswerBo> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
