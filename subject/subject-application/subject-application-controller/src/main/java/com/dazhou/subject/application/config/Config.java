//package com.dazhou.subject.application.config;
//
//import cn.hutool.core.date.DateUtil;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.support.WebBindingInitializer;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//
//import java.beans.PropertyEditorSupport;
//import java.util.Date;
//
///**
// * @author <a href="https://github.com/Dazhou-del">Dazhou</a>
// * @create 2024-03-16 20:40
// */
//@Configuration
//public class Config {
//
//    @Bean
//    public RequestMappingHandlerAdapter webBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
//        requestMappingHandlerAdapter.setWebBindingInitializer(new WebBindingInitializer() {
//            @Override
//            public void initBinder(WebDataBinder binder) {
//                binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
//                    @Override
//                    public void setAsText(String text) {
//                        // DateUtil.parse是hutool当中的方法
//                        setValue(DateUtil.parse(text));
//                    }
//                });
//
//                // 如果是字符串类型，就去除字符串的前后空格
//                binder.registerCustomEditor(String.class,
//                        new StringTrimmerEditor(true));
//            }
//        });
//        return requestMappingHandlerAdapter;
//    }
//}
//
