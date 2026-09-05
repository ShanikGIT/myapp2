package com.nikhil.myapp2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConsumer2 {

//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void receive(Employee employee) {
//
//        System.out.println("Consumer-2 received : " + employee);
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}