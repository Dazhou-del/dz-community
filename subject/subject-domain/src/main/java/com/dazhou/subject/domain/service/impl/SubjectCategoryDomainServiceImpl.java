package com.dazhou.subject.domain.service.impl;

import com.dazhou.subject.common.enums.IsDeletedFlagEnum;
import com.dazhou.subject.domain.convert.SubjectCategoryConverter;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.service.SubjectCategoryDomainService;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.dazhou.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:39
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public void update(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategoryService.update(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.code);
        List<SubjectCategory> subjectCategoryList=subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBo> subjectCategoryBoList = SubjectCategoryConverter.INSTANCE
                .convertCategoryToBo(subjectCategoryList);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryController.queryPrimaryCategory.subjectCategoryBoList:{}",subjectCategoryBoList);
        }
        //查询该分类下有多少个标签
        subjectCategoryBoList.forEach(bo->{
            Integer count=subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(count);
        });
        return subjectCategoryBoList;
    }


    @Override
    public List<SubjectCategoryBo> queryCategoryByPrimary(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.code);
        List<SubjectCategory> subjectCategoryList=subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBo> subjectCategoryBoList = SubjectCategoryConverter.INSTANCE
                .convertCategoryToBo(subjectCategoryList);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryController.queryPrimaryCategory.subjectCategoryBoList:{}",subjectCategoryBoList);
        }
        return subjectCategoryBoList;
    }

    @Override
    public void removeById(Long id) {
        subjectCategoryService.removeById(id);
    }
}
