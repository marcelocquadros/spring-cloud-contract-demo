package br.com.example.producer.eventhandler;

import br.com.example.producer.config.RabbitMQConfig;
import br.com.example.producer.domain.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void handleCreated(Product product) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY, product);
    }

}
