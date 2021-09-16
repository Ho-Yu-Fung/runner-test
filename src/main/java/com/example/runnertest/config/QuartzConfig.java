//package com.example.runnertest.config;
//
//import com.example.runnertest.other.QuartzTest;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//    @Bean
//    public JobDetail quartzTestJobDetail(){
//        return JobBuilder.newJob(QuartzTest.class)
//                .withIdentity("quartzTest")
//                .usingJobData("userName","Ho")
//                .usingJobData("userAge","123")
//                .storeDurably()
//                .build();
//    }
//    @Bean
//    public Trigger quartzTrigger(){
//        CronScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
//
//        return TriggerBuilder.newTrigger().forJob(quartzTestJobDetail())
//                .withIdentity("testTask1")
//                .withSchedule(schedule)
//                .build();
//    }
//}
