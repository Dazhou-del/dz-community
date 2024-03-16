package com.dazhou.subject.application.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dazhou.subject.infra.basic.entity.SubjectCategory;
import com.dazhou.subject.infra.basic.service.SubjectCategoryService;
import com.dazhou.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-14 21:29
 */
@RestController
public class SubjectController {
    @Resource
    private SubjectCategoryServiceImpl subjectCategoryService;


    /**
     * 测试接口
     * @return
     */
    @GetMapping("/test")
    private String test(){
        LambdaQueryWrapper<SubjectCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SubjectCategory::getId, 1L);
        return subjectCategoryService.getOne(queryWrapper).getCategoryName();
    }
}
