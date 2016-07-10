package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._7_controlling_phase_change_in_concurrent_phased_tasks;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();

        // Create five Student objects and register them in the phaser using the register() method.
        /*
        when you created the MyPhaser object, you didn't specify the number of
        participants in the phaser. You made a call to the register()  method for every Student
        object created to register a participant in the phaser. This calling doesn't establish a relation
        between the Student object or the thread that executes it and the phaser. Really, the
        number of participants in a phaser is only a number. There is no relationship between the
        phaser and the participants.
         */
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }

        // Create fie threads to run students and start them.
        Thread[] threads = new Thread[students.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(students[i], "Student_" + i);
            threads[i].start();
        }

        // Wait for the finalization of the fie threads.
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());

    }
}
