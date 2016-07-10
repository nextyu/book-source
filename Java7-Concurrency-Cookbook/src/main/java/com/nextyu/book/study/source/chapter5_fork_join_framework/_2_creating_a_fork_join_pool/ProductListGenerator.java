package com.nextyu.book.study.source.chapter5_fork_join_framework._2_creating_a_fork_join_pool;

import java.util.ArrayList;
import java.util.List;

/**
 * generate a list of random products
 *
 * @author zhouyu
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product_" + i);
            product.setPrice(10);
            products.add(product);
        }
        return products;
    }
}
