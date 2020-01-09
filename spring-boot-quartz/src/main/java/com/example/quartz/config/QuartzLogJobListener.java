package com.example.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/9
 */
@Slf4j
public class QuartzLogJobListener implements JobListener {
    @Override
    public String getName() {
        return "QuartzLogJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        JobKey key = context.getJobDetail().getKey();
        log.info("{}:jobToBeExecuted", key);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        JobKey key = context.getJobDetail().getKey();
        log.info("{}:jobExecutionVetoed", key);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        JobKey key = context.getJobDetail().getKey();
        log.info("{}:jobWasExecuted", key);
    }
}
