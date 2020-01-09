package com.example;

import com.example.quartz.QuartzApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/6
 */
@SpringBootTest(classes = QuartzApplication.class)
@RunWith(SpringRunner.class)
public class QuartzTest3 {

    @Test
    public void test1() throws InterruptedException, SchedulerException {
        TimeUnit.SECONDS.sleep(100);
    }
}
