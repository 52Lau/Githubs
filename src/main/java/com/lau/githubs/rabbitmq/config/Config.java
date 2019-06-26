package com.lau.githubs.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class Config {
    //立即消费的队列需要在mq后台创建
    //添加方式：1.浏览器打开：http://127.0.0.1:15672  2.选择Exchanges 3.Add a new exchange  ,填写name:exchange.demo.immediate,type选择：direct,点击Add exchange ，完成。

    //demo
    public static final String IMMEDIATE_QUEUE = "queue.demo.immediate";//立即消费的队列名称
    public static final String IMMEDIATE_EXCHANGE = "exchange.demo.immediate";//立即消费的exchange
    public static final String IMMEDIATE_ROUTING_KEY = "routingkey.demo.immediate";//立即消费的routing-key 名称
    public static final String DELAY_QUEUE= "queue.demo.delay";//延时消费的队列名称
    public static final String DEAD_LETTER_EXCHANGE = "exchange.demo.delay";//延时消费的exchange
    public static final String DELAY_ROUTING_KEY = "routingkey.demo.delay";//延时消费的routing-key名称

    //user
    public static final String USER_IMMEDIATE_QUEUE = "queue.user.immediate";//立即消费的队列名称
    public static final String USER_IMMEDIATE_EXCHANGE = "exchange.user.immediate";//立即消费的exchange
    public static final String USER_IMMEDIATE_ROUTING_KEY = "routingkey.user.immediate";//立即消费的routing-key 名称
    public static final String USER_DELAY_QUEUE= "queue.user.delay";//延时消费的队列名称
    public static final String USER_DEAD_LETTER_EXCHANGE = "exchange.user.delay";//延时消费的exchange
    public static final String USER_DELAY_ROUTING_KEY = "routingkey.user.delay";//延时消费的routing-key名称

    //repo
    public static final String REPO_IMMEDIATE_QUEUE = "queue.repo.immediate";//立即消费的队列名称
    public static final String REPO_IMMEDIATE_EXCHANGE = "exchange.repo.immediate";//立即消费的exchange
    public static final String REPO_IMMEDIATE_ROUTING_KEY = "routingkey.repo.immediate";//立即消费的routing-key 名称
    public static final String REPO_DELAY_QUEUE= "queue.repo.delay";//延时消费的队列名称
    public static final String REPO_DEAD_LETTER_EXCHANGE = "exchange.repo.delay";//延时消费的exchange
    public static final String REPO_DELAY_ROUTING_KEY = "routingkey.repo.delay";//延时消费的routing-key名称

    //follower
    public static final String FOLLOWER_IMMEDIATE_QUEUE = "queue.follower.immediate";//立即消费的队列名称
    public static final String FOLLOWER_IMMEDIATE_EXCHANGE = "exchange.follower.immediate";//立即消费的exchange
    public static final String FOLLOWER_IMMEDIATE_ROUTING_KEY = "routingkey.follower.immediate";//立即消费的routing-key 名称
    public static final String FOLLOWER_DELAY_QUEUE= "queue.follower.delay";//延时消费的队列名称
    public static final String FOLLOWER_DEAD_LETTER_EXCHANGE = "exchange.follower.delay";//延时消费的exchange
    public static final String FOLLOWER_DELAY_ROUTING_KEY = "routingkey.follower.delay";//延时消费的routing-key名称

    //following
    public static final String FOLLOWING_IMMEDIATE_QUEUE = "queue.following.immediate";//立即消费的队列名称
    public static final String FOLLOWING_IMMEDIATE_EXCHANGE = "exchange.following.immediate";//立即消费的exchange
    public static final String FOLLOWING_IMMEDIATE_ROUTING_KEY = "routingkey.following.immediate";//立即消费的routing-key 名称
    public static final String FOLLOWING_DELAY_QUEUE= "queue.following.delay";//延时消费的队列名称
    public static final String FOLLOWING_DEAD_LETTER_EXCHANGE = "exchange.following.delay";//延时消费的exchange
    public static final String FOLLOWING_DELAY_ROUTING_KEY = "routingkey.following.delay";//延时消费的routing-key名称



    /**
     * 创建的过多，直接传即时的exchange名称
     * @param immediateExchange
     * @return
     */
    public DirectExchange immediateExchange(String immediateExchange) {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(immediateExchange, true, false);
    }

    /**demo start**/
    // 创建一个立即消费队列
    @Bean
    public Queue immediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(IMMEDIATE_QUEUE, true);
    }

    // 创建一个延时队列
    @Bean
    public Queue delayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", IMMEDIATE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", IMMEDIATE_ROUTING_KEY);
        return new Queue(DELAY_QUEUE, true, false, false, params);
    }


    /*public DirectExchange immediateExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(IMMEDIATE_EXCHANGE, true, false);
    }*/

    @Bean
    public DirectExchange deadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(DEAD_LETTER_EXCHANGE, true, false);
    }

    //把立即消费的队列和立即消费的exchange绑定在一起
    @Bean
    public Binding immediateBinding() {
        return BindingBuilder.bind(immediateQueue()).to(immediateExchange(IMMEDIATE_EXCHANGE)).with(IMMEDIATE_ROUTING_KEY);
    }

    //把延时消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding delayBinding() {
        return BindingBuilder.bind(delayQueue()).to(deadLetterExchange()).with(DELAY_ROUTING_KEY);
    }

    /**demo end**/

    /**user start**/
// 创建一个立即消费队列
    @Bean
    public Queue userImmediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(USER_IMMEDIATE_QUEUE, true);
    }

    // 创建一个延时队列
    @Bean
    public Queue userDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", USER_IMMEDIATE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", USER_IMMEDIATE_ROUTING_KEY);
        return new Queue(USER_DELAY_QUEUE, true, false, false, params);
    }


    @Bean
    public DirectExchange userDeadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(USER_DEAD_LETTER_EXCHANGE, true, false);
    }

    //把立即消费的队列和立即消费的exchange绑定在一起
    @Bean
    public Binding userImmediateBinding() {
        return BindingBuilder.bind(userImmediateQueue()).to(immediateExchange(USER_IMMEDIATE_EXCHANGE)).with(USER_IMMEDIATE_ROUTING_KEY);
    }

    //把延时消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding userDelayBinding() {
        return BindingBuilder.bind(userDelayQueue()).to(userDeadLetterExchange()).with(USER_DELAY_ROUTING_KEY);
    }
    /**user end**/

    /**repo start**/
// 创建一个立即消费队列
    @Bean
    public Queue repoImmediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(REPO_IMMEDIATE_QUEUE, true);
    }

    // 创建一个延时队列
    @Bean
    public Queue repoDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", REPO_IMMEDIATE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", REPO_IMMEDIATE_ROUTING_KEY);
        return new Queue(REPO_DELAY_QUEUE, true, false, false, params);
    }

    @Bean
    public DirectExchange repoDeadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(REPO_DEAD_LETTER_EXCHANGE, true, false);
    }

    //把立即消费的队列和立即消费的exchange绑定在一起
    @Bean
    public Binding repoImmediateBinding() {
        return BindingBuilder.bind(repoImmediateQueue()).to(immediateExchange(REPO_IMMEDIATE_EXCHANGE)).with(REPO_IMMEDIATE_ROUTING_KEY);
    }

    //把延时消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding repoDelayBinding() {
        return BindingBuilder.bind(repoDelayQueue()).to(repoDeadLetterExchange()).with(REPO_DELAY_ROUTING_KEY);
    }
    /**repo end**/

    /**following start**/
// 创建一个立即消费队列
    @Bean
    public Queue followingImmediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(FOLLOWING_IMMEDIATE_QUEUE, true);
    }

    // 创建一个延时队列
    @Bean
    public Queue followingDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", FOLLOWING_IMMEDIATE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", FOLLOWING_IMMEDIATE_ROUTING_KEY);
        return new Queue(FOLLOWING_DELAY_QUEUE, true, false, false, params);
    }


    @Bean
    public DirectExchange followingDeadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(FOLLOWING_DEAD_LETTER_EXCHANGE, true, false);
    }

    //把立即消费的队列和立即消费的exchange绑定在一起
    @Bean
    public Binding followingImmediateBinding() {
        return BindingBuilder.bind(followingImmediateQueue()).to(immediateExchange(FOLLOWING_IMMEDIATE_EXCHANGE)).with(FOLLOWING_IMMEDIATE_ROUTING_KEY);
    }

    //把延时消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding followingDelayBinding() {
        return BindingBuilder.bind(followingDelayQueue()).to(followingDeadLetterExchange()).with(FOLLOWING_DELAY_ROUTING_KEY);
    }
    /**following end**/

    /**follower start**/
    // 创建一个立即消费队列
    @Bean
    public Queue followerImmediateQueue() {
        // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
        return new Queue(FOLLOWER_IMMEDIATE_QUEUE, true);
    }

    // 创建一个延时队列
    @Bean
    public Queue followerDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", FOLLOWER_IMMEDIATE_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", FOLLOWER_IMMEDIATE_ROUTING_KEY);
        return new Queue(FOLLOWER_DELAY_QUEUE, true, false, false, params);
    }


    @Bean
    public DirectExchange followerDeadLetterExchange() {
        // 一共有三种构造方法，可以只传exchange的名字， 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
        // 第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
        return new DirectExchange(FOLLOWER_DEAD_LETTER_EXCHANGE, true, false);
    }

    //把立即消费的队列和立即消费的exchange绑定在一起
    @Bean
    public Binding followerImmediateBinding() {
        return BindingBuilder.bind(followerImmediateQueue()).to(immediateExchange(FOLLOWER_IMMEDIATE_EXCHANGE)).with(FOLLOWER_IMMEDIATE_ROUTING_KEY);
    }

    //把延时消费的队列和延时消费的exchange绑定在一起
    @Bean
    public Binding followerDelayBinding() {
        return BindingBuilder.bind(followerDelayQueue()).to(followerDeadLetterExchange()).with(FOLLOWER_DELAY_ROUTING_KEY);
    }
    /**follower end**/
}