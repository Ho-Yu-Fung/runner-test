package com.example.runnertest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class RunnerTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunnerTestApplication.class, args);
        log.info("----------SpringBoot启动------------");
    }
//
//    @Scheduled(fixedRate = 1000)
//    public static void cron(){
//        log.info("--------------scheduling-"+new Date()+"------------");
//    }
}
