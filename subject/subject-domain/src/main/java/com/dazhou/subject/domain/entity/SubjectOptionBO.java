package com.dazhou.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目dto
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-24 23:10
 */
@Data
public class SubjectOptionBO implements Serializable {

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBo> optionList;

}
