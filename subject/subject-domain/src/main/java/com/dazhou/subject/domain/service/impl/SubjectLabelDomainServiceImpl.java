package com.dazhou.subject.domain.service.impl;

import com.dazhou.subject.domain.convert.SubjectLabelConverter;
import com.dazhou.subject.domain.entity.SubjectLabelBo;
import com.dazhou.subject.domain.service.SubjectLabelDomainService;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.dazhou.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:42
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Override
    public void add(SubjectLabelBo subjectLabelBo) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertLabelToBo(subjectLabelBo);
        subjectLabelService.insert(subjectLabel);
    }

    @Override
    public void update(SubjectLabelBo subjectLabelBo) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertLabelToBo(subjectLabelBo);
        subjectLabelService.updateById(subjectLabel);
    }

    @Override
    public void delete(SubjectLabelBo subjectLabelBo) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertLabelToBo(subjectLabelBo);
        subjectLabelService.removeById(subjectLabel);
    }

    @Override
    public List<SubjectLabelBo> queryLabelByCategoryId(SubjectLabelBo subjectLabelBo) {
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertLabelToBo(subjectLabelBo);
        List<SubjectLabel> subjectLabels = subjectLabelService.queryLabelByCategoryId(subjectLabel);
        List<SubjectLabelBo> subjectLabelBos = SubjectLabelConverter.INSTANCE.convertBoToLabelList(subjectLabels);
        return  subjectLabelBos;
    }


}
