package com.dazhou.subject.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求实体
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 17:11
 */
@Data
public class PageInfo implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}

