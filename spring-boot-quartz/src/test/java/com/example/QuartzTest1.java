package com.example;

import com.example.quartz.QuartzApplication;
import com.example.quartz.job.SampleJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/6
 */
@SpringBootTest(classes = QuartzApplication.class)
@RunWith(SpringRunner.class)
public class QuartzTest1 {
    @Autowired
    private Scheduler scheduler;

    /**
     * QuartzTest1
     * QuartzTest2
     * QuartzTest3
     * QuartzTest1启动后关闭，任务会转移到QuartzTest2、QuartzTest3中的一个实例
     */
    @Test
    public void test1() throws InterruptedException, SchedulerException {
        String identityName = SampleJob.class.getSimpleName();
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        SimpleTrigger trigger = TriggerBuilder.newTrigger().forJob(JobKey.jobKey(identityName))
                .startAt(new Date(new Date().getTime() + 10000))
                .withIdentity(identityName)
                .usingJobData("taskId", "11")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(trigger);
        TimeUnit.SECONDS.sleep(100);
    }
}
