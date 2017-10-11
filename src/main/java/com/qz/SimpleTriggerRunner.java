package com.qz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-10-11
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTriggerRunner {
    public static void main(String args[]){
        try {
            //①创建一个JobDetail实例，指定HelloJob

            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1","group1").build();
            //②通过SimpleTrigger定义调度规则：马上启动，每2秒运行一次，共运行100次
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("job1","group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                    .build();
            //③通过SchedulerFactory获取一个调度器实例
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            //④ 注册并进行调度
            scheduler.start();
            //⑤调度启动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
