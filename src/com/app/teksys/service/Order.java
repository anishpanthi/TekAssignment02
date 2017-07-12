package com.app.teksys.service;

import com.app.teksys.entity.OrderLine;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderLine> orderLines = new ArrayList<>();

    public void add(OrderLine o) throws Exception {
        if (o == null) {
            System.err.println("ERROR - Order is NULL");
            throw new IllegalArgumentException("Order is NULL");
        }
        this.orderLines.add(o);
    }

    public int size() {
        return this.orderLines.size();
    }

    public OrderLine get(int i) {
        return this.orderLines.get(i);
    }

    public void clear() {
        this.orderLines.clear();
    }
}
