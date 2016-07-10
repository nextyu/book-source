package com.nextyu.book.study.source.chapter3_thread_synchronization_utilities._7_controlling_phase_change_in_concurrent_phased_tasks;

import java.util.concurrent.Phaser;

/**
 * In this recipe, you will learn how to control the phase change in a phaser that is implementing
 * your own version of the Phaser class that overrides the onAdvance()  method to execute
 * some actions in every phase change. You are going to implement a simulation of an exam,
 * where there will be some students who have to do three exercises. All the students have to
 * fiish one exercise before they can proceed with the next one.
 *
 * @author zhouyu
 */
public class MyPhaser extends Phaser {

    /**
     * This method is called by the phaser before making a phase change and before waking up all
     * the threads that were sleeping in the arriveAndAwaitAdvance()  method. This method
     * receives as parameters the number of the actual phase, where 0 is the number of the fist
     * phase and the number of registered participants.
     * <p/>
     * The onAdvance()  method returns a Boolean value that indicates if the phaser has
     * terminated or not. If the phaser returns a false value, it indicates that it hasn't terminated,
     * so the threads will continue with the execution of other phases. If the phaser returns a true
     * value, then the phaser still wakes up the pending threads, but moves the phaser to the
     * terminated state, so all the future calls to any method of the phaser will return immediately,
     * and the isTerminated()  method returns the true value.
     *
     * @param phase
     * @param registeredParties
     * @return returns a Boolean value that indicates if the phaser has
     * terminated or not
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    /**
     * 完成全部测验
     * returns the true value to indicate that the phaser has finished its work
     * The onAdvance()  method returns a Boolean value that indicates if the phaser has
     * terminated or not
     *
     * @return
     */
    private boolean finishExam() {
        System.out.printf("Phaser: All the students have finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
    }

    /**
     * 完成测验二
     * returns the false value to indicate that the phaser continues with its execution
     * The onAdvance()  method returns a Boolean value that indicates if the phaser has
     * terminated or not
     *
     * @return
     */
    private boolean finishSecondExercise() {
        System.out.printf("Phaser: All the students have finished the second exercise.\n");
        System.out.printf("Phaser: It's time for the third one.\n");
        return false;
    }

    /**
     * 完成测验一
     * returns the false value to indicate that the phaser continues with its execution
     * The onAdvance()  method returns a Boolean value that indicates if the phaser has
     * terminated or not
     *
     * @return
     */
    private boolean finishFirstExercise() {
        System.out.printf("Phaser: All the students have finished the first exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        return false;
    }

    /**
     * 学生到齐
     * returns the false value to indicate that the phaser continues with its execution
     * The onAdvance()  method returns a Boolean value that indicates if the phaser has
     * terminated or not
     *
     * @return
     */
    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
        return false;
    }
}
