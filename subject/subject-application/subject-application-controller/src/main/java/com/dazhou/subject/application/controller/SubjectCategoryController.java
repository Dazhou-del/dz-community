package com.dazhou.subject.application.controller;

import com.dazhou.subject.application.convert.SubjectCategoryDTOConverter;
import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.common.entity.Result;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.service.SubjectCategoryDomainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题模块
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:53
 */
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("add")
    public Result<Boolean> add(SubjectCategoryDto subjectCategoryDto){
        try {
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok();
        } catch (Exception e) {
            return Result.fail();
        }
    }
}
