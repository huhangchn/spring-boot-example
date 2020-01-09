package com.example.quartz.config;

import com.example.quartz.job.SampleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/6
 */
@Configuration
public class QuartzConfiguration {
    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void postConstruct() throws SchedulerException {
        scheduler.getListenerManager().addJobListener(new QuartzLogJobListener());
    }

    @Bean
    public JobDetail sampleJobDetail() {
        String identityName = SampleJob.class.getSimpleName();
        return JobBuilder.newJob(SampleJob.class)
                .withDescription("示例任务")
                .withIdentity(identityName)
                .storeDurably().build();
    }
}
