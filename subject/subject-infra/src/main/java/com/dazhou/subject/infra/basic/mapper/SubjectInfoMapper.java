package com.dazhou.subject.infra.basic.mapper;

import com.dazhou.subject.infra.basic.entity.SubjectInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author da zhou
* @description 针对表【subject_info(题目信息表)】的数据库操作Mapper
* @createDate 2024-03-17 21:33:46
* @Entity com.dazhou.subject.infra.basic.entity.SubjectInfo
*/
public interface SubjectInfoMapper extends BaseMapper<SubjectInfo> {


    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,@Param("categoryId") Long categoryId,@Param("labelId") Long labelId);

    List<SubjectInfo> queryPage(@Param("subjectInfo")SubjectInfo subjectInfo, @Param("categoryId")Long categoryId, @Param("labelId")Long labelId, @Param("start")int start, @Param("pageSize")Integer pageSize);
}




