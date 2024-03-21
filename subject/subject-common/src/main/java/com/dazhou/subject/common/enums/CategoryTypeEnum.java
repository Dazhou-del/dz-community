package com.dazhou.subject.common.enums;

import lombok.Getter;

/**
 * 分类类型枚举
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-20 22:15
 */
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");

    public int code;

    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
