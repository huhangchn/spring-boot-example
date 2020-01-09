package com.example.quartz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author huhang
 * @date 2019/12/6
 */
@Slf4j
@Service
public class SampleService {
    public void test(Long taskId) {
        log.info("SampleService...{}", taskId);
    }
}
