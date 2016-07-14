package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._6;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * created on 2016-07-14 11:10
 *
 * @author nextyu
 */
public class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + record.getLevel() + "] - ");
        sb.append(new DateTime(record.getMillis()).toString("yyyy-MM-dd HH:mm:ss") + " : ");
        sb.append(record.getSourceClassName() + "." + record.getSourceMethodName() + " : ");
        sb.append(record.getMessage() + "\n");
        return sb.toString();
    }
}
