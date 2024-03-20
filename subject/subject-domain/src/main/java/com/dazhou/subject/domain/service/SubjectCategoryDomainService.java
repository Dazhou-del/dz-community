package com.dazhou.subject.domain.service;

import com.dazhou.subject.domain.entity.SubjectCategoryBo;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:39
 */
public interface SubjectCategoryDomainService {
    /**
     * 新增分类
     * @param subjectCategoryBo
     */
    void add(SubjectCategoryBo subjectCategoryBo);

    /**
     * 更新分类
     * @param subjectCategoryBo
     */
    void update(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询分类  根据categoryType查询
     * @param subjectCategoryBo
     * @return
     */
    List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询大类下的分类 categoryType和parentId查询
     * @param subjectCategoryBo
     * @return
     */
    List<SubjectCategoryBo> queryCategoryByPrimary(SubjectCategoryBo subjectCategoryBo);

    /**
     * 根据id删除
     * @param id
     */
    void removeById(Long id);
}
