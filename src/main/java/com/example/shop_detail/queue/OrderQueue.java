package com.example.shop_detail.queue;

import java.util.concurrent.DelayQueue;

public class OrderQueue {

    private OrderQueue() {
    }

    private DelayQueue<Order> delayQueue = new DelayQueue();
    private static final OrderQueue orderQueue = new OrderQueue();
    public static OrderQueue getOrderQueue() {
        return orderQueue;
    }

    public DelayQueue<Order> getDelayQueue() {
        return delayQueue;
    }
}
