package com.dazhou.subject.application.controller;

import com.dazhou.subject.application.convert.SubjectLabelDTOConverter;
import com.dazhou.subject.application.dto.SubjectLabelDto;
import com.dazhou.subject.common.entity.Result;
import com.dazhou.subject.domain.convert.SubjectLabelConverter;
import com.dazhou.subject.domain.entity.SubjectLabelBo;
import com.dazhou.subject.domain.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签模块
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:46
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     * @param subjectLabelDto
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDto subjectLabelDto){
        if (log.isInfoEnabled()){
            log.info("SubjectLabelController.add.subjectLabelDto:{}",subjectLabelDto);
        }
        Preconditions.checkNotNull(subjectLabelDto.getLabelName(),"标签名称不能为空");
        Preconditions.checkNotNull(subjectLabelDto.getCategoryId(),"分类Id不能为空");
        Preconditions.checkNotNull(subjectLabelDto.getSortNum(),"标签排序不能为空");
        try {
            SubjectLabelBo subjectLabelBo = SubjectLabelDTOConverter.INSTANCE.convertDoToInfoBo(subjectLabelDto);
            subjectLabelDomainService.add(subjectLabelBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("errMessage:{}",e.getMessage());
            return Result.fail("新增失败");

        }
    }

    /**
     * 更新标签
     * @param subjectLabelDto
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDto subjectLabelDto){
        if (log.isInfoEnabled()){
            log.info("SubjectLabelController.update.subjectLabelDto:{}",subjectLabelDto);
        }
        Preconditions.checkNotNull(subjectLabelDto.getId(),"标签Id不能为空");
        Preconditions.checkNotNull(subjectLabelDto.getLabelName(),"标签名称不能为空");
        Preconditions.checkNotNull(subjectLabelDto.getSortNum(),"标签排序不能为空");
        try {
            SubjectLabelBo subjectLabelBo = SubjectLabelDTOConverter.INSTANCE.convertDoToInfoBo(subjectLabelDto);
            subjectLabelDomainService.update(subjectLabelBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("errMessage:{}",e.getMessage());
            return Result.fail("更新失败");

        }
    }

    /**
     * 删除标签
     * @param subjectLabelDto
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDto subjectLabelDto){
        if (log.isInfoEnabled()){
            log.info("SubjectLabelController.delete.subjectLabelDto:{}",subjectLabelDto);
        }
        Preconditions.checkNotNull(subjectLabelDto.getId(),"标签Id不能为空");
        try {
            SubjectLabelBo subjectLabelBo = SubjectLabelDTOConverter.INSTANCE.convertDoToInfoBo(subjectLabelDto);
            subjectLabelDomainService.delete(subjectLabelBo);
            return Result.ok();
        } catch (Exception e) {
            log.error("errMessage:{}",e.getMessage());
            return Result.fail("删除失败");

        }
    }

    /**
     * 根据分类查询标签
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result queryLabelByCategoryId(@RequestBody SubjectLabelDto subjectLabelDto){
        if (log.isInfoEnabled()){
            log.info("SubjectLabelController.delete.subjectLabelDto:{}",subjectLabelDto);
        }
        Preconditions.checkNotNull(subjectLabelDto.getCategoryId(),"分类Id不能为空");
        try {
            SubjectLabelBo subjectLabelBo = SubjectLabelDTOConverter.INSTANCE.convertDoToInfoBo(subjectLabelDto);
            List<SubjectLabelBo> subjectLabelBos = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBo);
            List<SubjectLabelDto> subjectLabelDtos = SubjectLabelDTOConverter.INSTANCE.convertBoToInfoDtoList(subjectLabelBos);
            return Result.ok(subjectLabelDtos);
        } catch (Exception e) {
            log.error("errMessage:{}",e.getMessage());
            return Result.fail("删除失败");

        }
    }
}
