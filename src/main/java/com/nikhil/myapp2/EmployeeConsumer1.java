package com.nikhil.myapp2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConsumer1 {

//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void receive(Employee employee) {
//
//        System.out.println("Consumer-1 received : " + employee);
//
//        try {
//            Thread.sleep(3000);   // simulate processing
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void receivee(Employee employee) {
//
//        System.out.println("Received : " + employee);
//
//        throw new RuntimeException("Simulating processing failure");
//    }
}