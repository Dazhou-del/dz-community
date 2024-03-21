package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;

import com.dazhou.subject.domain.convert.MultipleSubjectConverter;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;
import com.dazhou.subject.infra.basic.entity.SubjectMultiple;
import com.dazhou.subject.infra.basic.service.SubjectMappingService;
import com.dazhou.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:09
 */
@Component
public class MultipleHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandler() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void addSubject(SubjectInfoBo subjectInfoBo) {
        //多选题目插入
        List<SubjectMultiple> subjectSList=new LinkedList<>();
        subjectInfoBo.getOptionList().forEach(option->{
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBotoMultiple(option);
            subjectMultiple.setSubjectId(subjectInfoBo.getId());
            subjectSList.add(subjectMultiple);
        });
        subjectMultipleService.saveBatch(subjectSList);
    }
}
