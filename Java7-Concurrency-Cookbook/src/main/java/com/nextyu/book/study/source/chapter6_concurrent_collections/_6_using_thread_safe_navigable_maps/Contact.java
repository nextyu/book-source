package com.nextyu.book.study.source.chapter6_concurrent_collections._6_using_thread_safe_navigable_maps;

/**
 * @author zhouyu
 */
public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
