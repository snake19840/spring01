package com.yujian.spring01.Exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 通过SimpleMappingExceptionResolver做全局异常的处理
 */

@Configuration
public class GlobaException {
    /**
     *该方法必须要有返回值,返回值类型必须是,SimpleMappingExceptionResolver
     *
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
        Properties mappings=new Properties();
        /**
         * 参数一:异常的类型,注意必须是异常类型的全名(包括包名)
         * 参数二:视图名称
         */
        mappings.put("java.lang.ArithmeticException","error1");
        mappings.put("java.lang.NullPointerException.class","error2");
        resolver.setExceptionMappings(mappings);
        return resolver;

    }
}
