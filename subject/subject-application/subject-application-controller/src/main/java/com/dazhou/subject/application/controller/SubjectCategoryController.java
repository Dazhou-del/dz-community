package com.dazhou.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.dazhou.subject.application.convert.SubjectCategoryDTOConverter;
import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.common.entity.Result;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.service.SubjectCategoryDomainService;
import com.dazhou.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 刷题模块
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:53
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @Resource
    private SubjectCategoryServiceImpl subjectCategoryService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
//            这样写性能高
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok();
        } catch (Exception e) {
            return Result.fail();
        }

    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@Param("Id") Long Id){
//        try {
        //这样写性能高
//            if (log.isInfoEnabled()){
//                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
//            }
        subjectCategoryService.removeById(Id);
//        subjectCategoryDomainService.add(subjectCategoryBo);
        return Result.ok();
//        } catch (Exception e) {
//            return Result.fail();
//        }
    }
}
