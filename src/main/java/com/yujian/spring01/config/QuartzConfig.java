package com.yujian.spring01.config;

import com.yujian.spring01.Job.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz配置类
 */

@Configuration
public class QuartzConfig {
    /**
     * 1.创建JOB对象
     *
     */
    @Bean
     public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory=new JobDetailFactoryBean();
        //关联我们自动的JOB类
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }
     /**
     * 2.创建trigger对象
      * 简单的trigger创建
      */
     /*
     @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
         SimpleTriggerFactoryBean factory=new SimpleTriggerFactoryBean();
         //关联JobDetail对象
         factory.setJobDetail(jobDetailFactoryBean.getObject());
         //该陈参数表示一个执行的毫秒数
         factory.setRepeatInterval(2000);
         //设置重复次数
         factory.setRepeatCount(5);
         return factory;
     }
*/
    /**
     * 2.创建trigger对象
     * Cron的trigger创建
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factory=new CronTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        //设置触发时间
        factory.setCronExpression("0/2 * * * * ?");
        return factory;
    }


     /**
     * 3.创建Scheduler对象
     */
     /*
     @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean){
         SchedulerFactoryBean factory=new SchedulerFactoryBean();
         //关联trigger
         factory.setTriggers(simpleTriggerFactoryBean.getObject());
         return factory;
     }
*/
     @Bean
     public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
         SchedulerFactoryBean factory=new SchedulerFactoryBean();
         //关联trigger
         factory.setTriggers(cronTriggerFactoryBean.getObject());
         factory.setJobFactory(myAdaptableJobFactory);
         return factory;
     }

}
