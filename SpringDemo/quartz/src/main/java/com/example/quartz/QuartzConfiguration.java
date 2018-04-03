/**********************************************************************************************************************
 * FileName - QuartzConfiguration.java
 *
 * (c) Disney. All rights reserved.
 *
 * @Author: lel026 $$ 
 * @Revision: #1 $$ 
 * @Change: 715510 $$ 
 * @Date 3/22/18 $$ 
 **********************************************************************************************************************/
package com.example.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

@Configuration
public class QuartzConfiguration {
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(HelloJob job){
        MethodInvokingJobDetailFactoryBean jobDetail=new MethodInvokingJobDetailFactoryBean();
        jobDetail.setConcurrent(false);
        jobDetail.setName("HelloJob");
        jobDetail.setGroup("HelloGroup");
        jobDetail.setTargetObject(job);
        jobDetail.setTargetMethod("execute");
        return jobDetail;
    }

    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail){
        CronTriggerFactoryBean trigger=new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail.getObject());
        trigger.setCronExpression("0 30 20 * * ?");
        trigger.setName("HelloTrigger");
        return trigger;
    }
}
