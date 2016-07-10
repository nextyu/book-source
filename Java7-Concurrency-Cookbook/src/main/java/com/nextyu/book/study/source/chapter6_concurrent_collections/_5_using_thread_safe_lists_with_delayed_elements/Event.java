
package com.nextyu.book.study.source.chapter6_concurrent_collections._5_using_thread_safe_lists_with_delayed_elements;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouyu
 */
public class Event implements Delayed {

    /**
     * 开始执行的时间
     *
     * the activation date of the events
     */
    private Date startDate;

    public Event(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 返回开始执行的时间和当前时间的时间差，纳秒，
     * 比如，现在2016-06-17 10:00，事件开始时间是2016-06-17 11:00，取它们之间的时间差
     * returns the number of nanoseconds between the activation date and the actual date
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        // Convert the given time duration in the given unit to this unit.
        // 把 MILLISECONDS 转为 NANOSECONDS
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        }
        return 0;
    }
}
