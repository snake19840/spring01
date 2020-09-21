package com.yujian.spring01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {

	//1.job：任务，你要做什么事？
        JobDetail job= JobBuilder.newJob(QuartzDemo.class).build();

    //2.    Trigger：触发器，你什么时候去做什么事？
        /**
         * 简单的trigger触发时间,通过Quartz提供一个方法来完成简单的重复调
         * cron Trigger,按照Cron的表达式给定触发的时间
         */
        /*
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(5,2)).build();
        */
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();


    //3.    Scheduler：任务调度，你什么时候需要去做什么事？
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job,trigger);

        //启动
        scheduler.start();

    }
}
