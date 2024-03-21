package com.dazhou.subject.application.dto;

import lombok.Data;

/**
 * 题目答案dto
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-20 22:24
 */
@Data
public class SubjectAnswerDto {
    /**
     * 答案类型
     */
    private Integer optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;
}
