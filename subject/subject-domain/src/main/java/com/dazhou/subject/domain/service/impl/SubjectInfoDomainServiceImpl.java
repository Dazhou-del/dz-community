package com.dazhou.subject.domain.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.domain.convert.SubjectInfoConverter;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.handler.subject.HandlerFactory;
import com.dazhou.subject.domain.handler.subject.SubjectTypeHandler;
import com.dazhou.subject.domain.service.SubjectInfoDomainService;
import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.dazhou.subject.infra.basic.entity.SubjectMapping;
import com.dazhou.subject.infra.basic.service.SubjectInfoService;
import com.dazhou.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectInfoDomainServiceImpl.add.subjectInfoBo:{}",subjectInfoBo);
            }
            SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBotoInfo(subjectInfoBo);
            subjectInfoService.save(subjectInfo);

            //策略模式+工厂
            SubjectTypeHandler handler = handlerFactory.getHandler(subjectInfoBo.getSubjectType());
            subjectInfoBo.setId(subjectInfo.getId());
            handler.addSubject(subjectInfoBo);

            //插入题目分类关系表
            List<Integer> categoryIds = subjectInfoBo.getCategoryIds();
            List<Integer> labelIds = subjectInfoBo.getLabelIds();
            List<SubjectMapping> subjectMappings=new LinkedList<>();

            categoryIds.forEach(categoryId->{
                labelIds.forEach(labelId->{
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
            log.error("SubjectInfoDomainServiceImpl.add.error:{}",e.getMessage(),e);
        }


    }
}
