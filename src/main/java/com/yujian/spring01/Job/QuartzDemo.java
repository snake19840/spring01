package com.yujian.spring01.Job;

import com.yujian.spring01.Service.UsersAddService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class QuartzDemo implements Job {
    @Autowired
    private UsersAddService usersAddService;
    /**
     * 任务触发执行方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute...."+new Date());
        this.usersAddService.addUsers();
    }


}
