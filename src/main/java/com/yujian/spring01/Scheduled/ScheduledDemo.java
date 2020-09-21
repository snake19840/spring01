package com.yujian.spring01.Scheduled;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledDemo {
    /**
     * 定时任务方法
     * @Scheduled :设置定时任务
     * cron属性:cron表达式,定时任务触发是时间的一个字符表达示
     */
    @Scheduled(cron = "0/4 * * * * ?")
    public void scheduledMethod(){
        System.out.println("定时任务触发"+ new Date());

    }
}
