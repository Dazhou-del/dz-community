package com.dazhou.subject.domain.service;

import com.dazhou.subject.domain.entity.SubjectLabelBo;

import java.util.List;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:41
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     * @param subjectLabelBo
     */
    void add(SubjectLabelBo subjectLabelBo);

    /**
     * 跟新标签
     * @param subjectLabelBo
     */
    void update(SubjectLabelBo subjectLabelBo);

    /**
     * 删除标签
     * @param subjectLabelBo
     */
    void delete(SubjectLabelBo subjectLabelBo);

    /**
     * 根据分类查询标签
     * @param subjectLabelBo
     */
    List<SubjectLabelBo> queryLabelByCategoryId(SubjectLabelBo subjectLabelBo);
}
