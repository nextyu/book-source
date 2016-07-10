package com.nextyu.book.study.source.chapter4_thread_executors._5_running_multiple_tasks_and_processing_the_first_result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author smile
 */
public class Main {
    public static void main(String[] args) {
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);

        List<TaskValidator> taskValidators = new ArrayList<>();
        taskValidators.add(ldapTask);
        taskValidators.add(dbTask);

        ExecutorService executor = (ExecutorService) Executors.
                newCachedThreadPool();

        String result;

        try {
            /*
            The invokeAny()  method of the ThreadPoolExecutor class receives a list of tasks,
            launches them, and returns the result of the fist task that fiishes without throwing an exception.
             */
            result = executor.invokeAny(taskValidators);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
