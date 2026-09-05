package com.nikhil.myapp2;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.QueueBuilder;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "employee.queue";

    public static final String EXCHANGE = "employee.exchange";

    public static final String ROUTING_KEY = "employee.routingkey";

    public static final String DLX = "employee.dlx";

    public static final String DLQ = "employee.dead.queue";

    public static final String DL_ROUTING = "employee.dead";

    public static final String DELAY_QUEUE = "employee.delay.queue";

    @Bean
    Queue queue() {

        return QueueBuilder
                .durable(QUEUE)
                .deadLetterExchange(DLX)
                .deadLetterRoutingKey(DL_ROUTING)
                .build();
    }
    @Bean
    DirectExchange deadLetterExchange() {
        return new DirectExchange(DLX);
    }
    @Bean
    Queue deadQueue() {
        return new Queue(DLQ);
    }
    @Bean
    Binding deadBinding() {

        return BindingBuilder
                .bind(deadQueue())
                .to(deadLetterExchange())
                .with(DL_ROUTING);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("employee.fanout");
    }
    @Bean
    Queue queueOne() {
        return new Queue("employee.queue.one", true);
    }

    @Bean
    Queue queueTwo() {
        return new Queue("employee.queue.two", true);
    }
    @Bean
    Binding fanoutBindingOne(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueOne())
                .to(fanoutExchange);
    }

    @Bean
    Binding fanoutBindingTwo(FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueTwo())
                .to(fanoutExchange);
    }
    @Bean
    Queue delayQueue() {

        return  QueueBuilder
                .durable(DELAY_QUEUE)
                .ttl(10000)                 // 10 seconds
                .deadLetterExchange("")
                .deadLetterRoutingKey(QUEUE)
                .build();
    }
}