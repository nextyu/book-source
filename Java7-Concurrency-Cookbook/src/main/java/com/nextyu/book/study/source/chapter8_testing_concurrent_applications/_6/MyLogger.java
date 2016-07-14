package com.nextyu.book.study.source.chapter8_testing_concurrent_applications._6;

import java.io.IOException;
import java.util.logging.*;

/**
 * created on 2016-07-14 11:13
 *
 * @author nextyu
 */
public class MyLogger {
    private static Handler handler;

    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.ALL);
        try {
            if (handler == null) {
                handler = new FileHandler("F:/recipe8.log");
                Formatter formatter = new MyFormatter();
                handler.setFormatter(formatter);
            }
            if (logger.getHandlers().length == 0) {
                logger.addHandler(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logger;
    }
}
