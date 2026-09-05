package com.nikhil.myapp2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumerOne {

    @RabbitListener(queues = "employee.queue.one")
    public void receive(Employee employee) {

        System.out.println("Fanout Consumer-1");
        System.out.println(employee);

    }
}