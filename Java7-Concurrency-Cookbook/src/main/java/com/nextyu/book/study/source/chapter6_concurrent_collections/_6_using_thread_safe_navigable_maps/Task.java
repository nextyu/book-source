package com.nextyu.book.study.source.chapter6_concurrent_collections._6_using_thread_safe_navigable_maps;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author zhouyu
 */
public class Task implements Runnable {

    private ConcurrentSkipListMap<String,Contact> map;

    /**
     * store the ID of the current task
     */
    private String id;

    public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(id, String.valueOf(i + 1000));
            map.put(id + contact.getPhone(), contact);
        }
    }
}
