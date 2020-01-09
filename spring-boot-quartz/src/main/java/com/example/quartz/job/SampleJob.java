package com.example.quartz.job;

import com.example.quartz.service.SampleService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/6
 */
@Slf4j
public class SampleJob extends QuartzJobBean {
    @Setter
    private Long taskId;
    @Resource
    private SampleService sampleService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sampleService.test(taskId);
    }
}
