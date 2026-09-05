package com.nikhil.myapp2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumerTwo {

    @RabbitListener(queues = "employee.queue.two")
    public void receive(Employee employee) {

        System.out.println("Fanout Consumer-2");
        System.out.println(employee);

    }
}