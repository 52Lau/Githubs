package com.lau.githubs.common;

public abstract class Constants {

    public static final String IMMEDIATE_QUEUE="immediate_queue";

    //声明了队列里的死信转发到的DLX名称
    public static final String IMMEDIATE_EXCHANGE="immediate_exchange";

    //声明了这些死信在转发时携带的 routing-key 名称
    public static final String IMMEDIATE_ROUTING_KEY="immediate_routing_key";


    public static final String DELAY_QUEUE="delay_queue";

    public static final String DEAD_LETTER_EXCHANGE="dead_letter_exchange";

    public static final String DELAY_ROUTING_KEY="delay_routing_key";

}
