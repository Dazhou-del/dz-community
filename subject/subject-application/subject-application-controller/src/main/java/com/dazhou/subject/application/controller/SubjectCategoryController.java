package com.dazhou.subject.application.controller;

import cn.hutool.core.util.StrUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类模块
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 16:53
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;



    /**
     * 新增分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
//            这样写性能高
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            //断言的形式校验参数
            Preconditions.checkNotNull(subjectCategoryDto.getCategoryType(),"分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDto.getParentId(),"父级Id不能为空");
            Preconditions.checkArgument(StrUtil.isNotEmpty(subjectCategoryDto.getCategoryName()),"分类名称不能为空");

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.dto:{}",e.getMessage(),e);
            return Result.fail("新增失败");
        }

    }

    /**
     * 删除分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDto subjectCategoryDto){
        Long Id = subjectCategoryDto.getId();
        Preconditions.checkNotNull(subjectCategoryDto.getId(),"传入id不能为空");
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectCategoryController.delete.Id:{}", subjectCategoryDto.getId());
            }
            subjectCategoryDomainService.removeById(Id);
        return Result.ok();
        } catch (Exception e) {
            return Result.fail("删除失败");
        }
    }

    /**
     * 更新分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            //这样写性能高
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            //断言的形式校验参数
            Preconditions.checkNotNull(subjectCategoryDto.getId(), "分类Id不能为空");

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            subjectCategoryDomainService.update(subjectCategoryBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.dto:{}", e.getMessage(), e);
            return Result.fail("更新失败");
        }
    }

    /**
     * 根据分类类型查询分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/queryPrimaryCategory")
    public Result<Boolean> queryPrimaryCategory(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBoList=subjectCategoryDomainService.queryCategory(subjectCategoryBo);
            List<SubjectCategoryDto> subjectCategoryDtos = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategoryDTOList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDtos);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.dto:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }


    /**
     * 查询大类下分类 根据parentId和categoryType查询
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<Boolean> queryCategoryByPrimary(@RequestBody SubjectCategoryDto subjectCategoryDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDto));
            }
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategory(subjectCategoryDto);
            List<SubjectCategoryBo> subjectCategoryBoList=subjectCategoryDomainService.queryCategoryByPrimary(subjectCategoryBo);
            List<SubjectCategoryDto> subjectCategoryDtos = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategoryDTOList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDtos);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.dto:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

}
