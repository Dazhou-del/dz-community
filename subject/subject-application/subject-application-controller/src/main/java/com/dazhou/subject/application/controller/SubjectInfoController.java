package com.dazhou.subject.application.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.dazhou.subject.application.convert.SubjectInfoDTOConverter;
import com.dazhou.subject.application.dto.SubjectInfoDto;
import com.dazhou.subject.common.entity.Result;
import com.dazhou.subject.domain.entity.SubjectAnswerBo;
import com.dazhou.subject.domain.entity.SubjectInfoBo;
import com.dazhou.subject.domain.service.SubjectInfoDomainService;
import com.dazhou.subject.infra.basic.service.SubjectInfoService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题模块
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-17 21:46
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectInfoController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody SubjectInfoDto subjectInfoDto){
        try {
            if (log.isInfoEnabled()){
                log.info("SubjectInfoController.add.SubjectInfoDto:{}",subjectInfoDto);
            }
            Preconditions.checkNotNull(subjectInfoDto.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDto.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtil.isEmpty(subjectInfoDto.getCategoryIds()),"分类id不能为空");
            Preconditions.checkArgument(!CollectionUtil.isEmpty(subjectInfoDto.getLabelIds()),"标签id不能为空");

            SubjectInfoBo subjectInfoBo = SubjectInfoDTOConverter.INSTANCE.convertToBoInfo(subjectInfoDto);
            List<SubjectAnswerBo> subjectAnswerBos = SubjectInfoDTOConverter.INSTANCE.convertListToBoInfo(subjectInfoDto.getOptionList());
            subjectInfoBo.setOptionList(subjectAnswerBos);
            subjectInfoDomainService.add(subjectInfoBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectInfoController.add.error:{}",e.getMessage(),e);
            return Result.fail("新增题目失败");
        }

    }
}
