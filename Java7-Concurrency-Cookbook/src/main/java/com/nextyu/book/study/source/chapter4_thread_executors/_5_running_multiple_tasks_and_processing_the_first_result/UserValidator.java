package com.nextyu.book.study.source.chapter4_thread_executors._5_running_multiple_tasks_and_processing_the_first_result;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 处理用户校验
 *
 * @author smile
 */
public class UserValidator {
    /**
     * 用户校验系统的名称
     */
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 校验用户
     *
     * @param name     用户名
     * @param password 密码
     * @return
     */
    public boolean validate(String name, String password) {
        Random random = new Random();
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }
}
