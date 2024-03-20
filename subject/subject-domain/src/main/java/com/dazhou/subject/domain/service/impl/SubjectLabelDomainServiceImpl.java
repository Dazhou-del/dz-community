package com.dazhou.subject.domain.service.impl;

import com.dazhou.subject.common.enums.CategoryTypeEnum;
import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.domain.convert.SubjectLabelConverter;
import com.dazhou.subject.domain.entity.SubjectLabelBo;
import com.dazhou.subject.domain.service.SubjectLabelDomainService;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;
import com.dazhou.subject.infra.basic.service.SubjectCategoryService;
import com.dazhou.subject.infra.basic.service.SubjectLabelService;
import com.dazhou.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:42
 */
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectMappingService subjectMappingService;

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
        //如果当前分类是1级分类，则查询所有标签
        SubjectCategory subjectCategory=subjectCategoryService.queryByCategoryId(subjectLabelBo.getCategoryId());
//        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertLabelToBo(subjectLabelBo);
        if (CategoryTypeEnum.PRIMARY.getCode()==subjectCategory.getCategoryType()){
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBo.getCategoryId());
            List<SubjectLabel> labelList = subjectLabelService.queryByCondition(subjectLabel);
            List<SubjectLabelBo> subjectLabelBos = SubjectLabelConverter.INSTANCE.convertBoToLabelList(labelList);
            return subjectLabelBos;
        }
        Long categoryId = subjectLabelBo.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBo> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBo bo = new SubjectLabelBo();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;
    }


}
