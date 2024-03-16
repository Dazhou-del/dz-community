package com.dazhou.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.dazhou.subject.application.convert.SubjectCategoryDTOConverter;
import com.dazhou.subject.application.dto.SubjectCategoryDto;
import com.dazhou.subject.common.entity.Result;
import com.dazhou.subject.domain.entity.SubjectCategoryBo;
import com.dazhou.subject.domain.service.SubjectCategoryDomainService;
import com.dazhou.subject.infra.basic.service.impl.SubjectCategoryServiceImpl;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
            //断言的形式校验参数
            Preconditions.checkNotNull(subjectCategoryDto.getCategoryType(),"分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(),"父级Iddf不能为空");
            Preconditions.checkArgument(StringUtils.isEmpty(subjectCategoryDto.getCategoryName()),"分类名称不能为空");

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.dto:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
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
