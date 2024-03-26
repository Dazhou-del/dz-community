package com.dazhou.subject.domain.service.impl;

import com.dazhou.subject.common.entity.PageResult;
import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.domain.convert.SubjectInfoConverter;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.entity.SubjectOptionBO;
import com.dazhou.subject.domain.handler.subject.HandlerFactory;
import com.dazhou.subject.domain.handler.subject.SubjectTypeHandler;
import com.dazhou.subject.domain.service.SubjectInfoDomainService;
import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.dazhou.subject.infra.basic.entity.SubjectLabel;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;
import com.dazhou.subject.infra.basic.service.SubjectInfoService;
import com.dazhou.subject.infra.basic.service.SubjectLabelService;
import com.dazhou.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:42
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private HandlerFactory handlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBo subjectInfoBo) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoDomainServiceImpl.add.subjectInfoBo:{}", subjectInfoBo);
            }
            SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBotoInfo(subjectInfoBo);
            subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectInfoService.save(subjectInfo);

            //策略模式+工厂
            SubjectTypeHandler handler = handlerFactory.getHandler(subjectInfoBo.getSubjectType());
            subjectInfoBo.setId(subjectInfo.getId());
            handler.addSubject(subjectInfoBo);

            //插入题目分类关系表
            List<Integer> categoryIds = subjectInfoBo.getCategoryIds();
            List<Integer> labelIds = subjectInfoBo.getLabelIds();
            List<SubjectMapping> subjectMappings = new LinkedList<>();

            categoryIds.forEach(categoryId -> {
                labelIds.forEach(labelId -> {
                    SubjectMapping subjectMapping = new SubjectMapping();
                    subjectMapping.setSubjectId(subjectInfoBo.getId());
                    subjectMapping.setCategoryId(Long.valueOf(categoryId));
                    subjectMapping.setLabelId(Long.valueOf(labelId));
                    subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                    subjectMappings.add(subjectMapping);
                });
            });
            subjectMappingService.saveBatch(subjectMappings);
        } catch (Exception e) {
            log.error("SubjectInfoDomainServiceImpl.add.error:{}", e.getMessage(), e);
        }


    }

    @Override
    public PageResult<SubjectInfoBo> getSubjectPage(SubjectInfoBo subjectInfoBo) {
        PageResult<SubjectInfoBo> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBo.getPageNo());
        pageResult.setPageSize(subjectInfoBo.getPageSize());
        //start固定算法
        int start = (subjectInfoBo.getPageNo() - 1) * subjectInfoBo.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBotoInfo(subjectInfoBo);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBo.getCategoryId(), subjectInfoBo.getLabelId());
        //无数据直接返回
        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBo.getCategoryId()
                , subjectInfoBo.getLabelId(), start, subjectInfoBo.getPageSize());
        List<SubjectInfoBo> subjectInfoBoList = SubjectInfoConverter.INSTANCE.convertListInfoToBo(subjectInfoList);
        pageResult.setTotal(count);
        pageResult.setRecords(subjectInfoBoList);
        return pageResult;
    }

    @Override
    public SubjectInfoBo querySubjectInfo(SubjectInfoBo subjectInfoBo) {
        SubjectInfo subjectInfo = subjectInfoService.getById(subjectInfoBo.getId());
        SubjectTypeHandler handler = handlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());

        SubjectInfoBo bo = SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        //查询题目映射表
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        //查询题目标签
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelNames(labelNameList);
        return bo;
    }
}
