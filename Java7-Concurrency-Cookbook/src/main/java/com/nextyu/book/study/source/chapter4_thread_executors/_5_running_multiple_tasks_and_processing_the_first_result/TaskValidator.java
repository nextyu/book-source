package com.nextyu.book.study.source.chapter4_thread_executors._5_running_multiple_tasks_and_processing_the_first_result;

import java.util.concurrent.Callable;

/**
 * @author smile
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String name;
    private String password;

    public TaskValidator(UserValidator validator, String name, String password) {
        this.validator = validator;
        this.name = name;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!validator.validate(name, password)) {
            System.out.printf("%s: The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        } else {
            System.out.printf("%s: The user has been found\n", validator.
                    getName());
            return validator.getName();
        }
    }
}
