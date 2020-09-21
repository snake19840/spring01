package com.yujian.spring01.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

//@Component("myAdaptableJobFactory")可以使用spring将该对象实例化
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    /**
     * AutowireCapableBeanFactory该方法可以将一个对象添加到SpringIOC容器中,并且完成对象的注入
     */
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    /**
     * 该方法需要将实例化的任务对象手动添加springIOC容器中并且完成对象的注入
     * @param bundle
     * @return
     * @throws Exception
     */

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj=super.createJobInstance(bundle);
        //将obj对象添加到Spring IOC容器中,并完成注入
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}
