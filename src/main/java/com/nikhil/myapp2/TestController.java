package com.nikhil.myapp2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RabbitTemplate rabbitTemplate;

    public TestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String send(@RequestBody Employee employee) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                employee
        );

        return "Object Sent";
    }
    @GetMapping("/fanout")
    public String sendFanout() {

        Employee employee = new Employee(
                100L,
                "Nikhil",
                "Backend",
                100000.0
        );

        rabbitTemplate.convertAndSend(
                "employee.fanout",
                "",
                employee
        );

        return "Fanout Message Sent";
    }
    @GetMapping("/delay")
    public String sendDelayed() {

        Employee employee = new Employee(
                999L,
                "Delayed Employee",
                "IT",
                90000.0
        );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.DELAY_QUEUE,
                employee
        );

        return "Delayed Message Sent";
    }
}