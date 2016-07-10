package com.nextyu.book.study.source.chapter2_basic_thread_synchronization._3_arranging_independent_attributes_in_synchronized_classes;

/**
 * @author zhouyu
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);

        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
        Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

        thread1.start();
        thread2.start();

        // 等待线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 Vacancies: %d\n",cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n",cinema.getVacanciesCinema2());

    }
}
