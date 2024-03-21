package com.dazhou.subject.domain.handler.subject;

import com.dazhou.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler工厂
 * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
 * @create 2024-03-21 10:15
 */
@Component
public class HandlerFactory implements InitializingBean {

    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlers;

    private  Map<SubjectInfoTypeEnum,SubjectTypeHandler> handlerMap=new HashMap<>();

    public  SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        subjectTypeHandlers.forEach(subjectTypeHandler -> {
            handlerMap.put(subjectTypeHandler.getHandler(),subjectTypeHandler);
        });
    }
}
