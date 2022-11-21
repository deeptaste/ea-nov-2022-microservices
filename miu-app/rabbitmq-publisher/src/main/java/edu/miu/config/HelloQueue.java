package edu.miu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloQueue {

    @Bean
    public Queue hiQueue1() {
        return new Queue("Hello-queue-1", true);
    }

    @Bean
    public Queue hiQueue2() {
        return new Queue("Hello-queue-2", true);
    }

    @Bean
    FanoutExchange helloFanoutExchange() {
        return new FanoutExchange("Hello-fanout-exchange");
    }

    @Bean
    TopicExchange helloTopicExchange() {
        return new TopicExchange("Hello-topic-exchange");
    }

    @Bean
    Binding helloQueue1binding(Queue hiQueue1, FanoutExchange helloFanoutExchange) {
        return BindingBuilder.bind(hiQueue1).to(helloFanoutExchange);
    }

//    @Bean
//    Binding helloQueue3binding(Queue hiQueue1, TopicExchange helloTopicExchange) {
//        return BindingBuilder.bind(hiQueue1).to(helloTopicExchange);
//        //return BindingBuilder.bind(hiQueue1).to(helloTopicExchange);
//    }

    @Bean
    Binding helloQueue2binding(Queue hiQueue2, FanoutExchange helloFanoutExchange) {
        return BindingBuilder.bind(hiQueue2).to(helloFanoutExchange);
    }
}
