//package com.example.runnertest.other;
//
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//@Slf4j
//@Component
//public class QuartzTest extends QuartzJobBean {
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        /**
//         * 业务逻辑处理
//         */
//        String userName = (String)jobExecutionContext.getJobDetail().getJobDataMap().get("userName");
//        String age = (String)jobExecutionContext.getJobDetail().getJobDataMap().get("userAge");
//        log.info("------------------------------");
//        log.info("----------{}---------",userName);
//        log.info("----------{}---------",age);
//        log.info("time:->>"+new SimpleDateFormat("YYYY/MM/dd-HH:mm:ss").format(new Date()));
//        log.info("------------------------------");
//    }
//}
