package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._3_arranging_independent_attributes_in_synchronized_classes;

/**
 * 编程模拟一家电影院有两个屏幕和两个售票处。当一个售票处出售门票，
 * 它们用于两个电影院的其中一个，但不能用于两个，所以在每个电影院空闲的席位的数量是独立的属性。
 *
 * @author zhouyu
 */
public class Cinema {
    // 电影院空闲座位数
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    /**
     * 第一个电影院出售一些门票将调用它
     *
     * @param number
     * @return
     */
    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if (number < vacanciesCinema1) {
                vacanciesCinema1 -= number;
                return true;
            }
            return false;
        }
    }

    /**
     * 第二个电影院出售一些门票将调用它
     *
     * @param number
     * @return
     */
    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if (number < vacanciesCinema2) {
                vacanciesCinema2 -= number;
                return true;
            }
            return false;
        }
    }

    /**
     * 当第一个电影院被退回一些票时将调用它
     *
     * @param number
     * @return
     */
    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += number;
            return true;
        }
    }

    /**
     * 当第二个电影院被退回一些票时将调用它
     *
     * @param number
     * @return
     */
    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += number;
            return true;
        }
    }


    /**
     * 返回每个电影院空缺位置的数量
     *
     * @return
     */
    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}
