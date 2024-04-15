package com.dazhou.gateway.enums;


import lombok.Getter;

/**
 * 返回状态枚举
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-16 17:03
 */
@Getter

public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    public int code;

    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
