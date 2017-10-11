package com.qz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-10-11
 * Time: 上午10:50
 * To change this template use File | Settings | File Templates.
 */
public class HelloJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       System.out.println("HelloJob");
    }
}
