package pl.goreit.opf2.infrastructure.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import pl.goreit.generated.InterchangeModel;

@Component
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String interchangeModel) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend("interchangeQ", interchangeModel);
    }

}