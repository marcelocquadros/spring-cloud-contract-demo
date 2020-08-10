package br.com.sample.consumer.listener;

import br.com.sample.consumer.config.RabbitMQConfig;
import br.com.sample.consumer.domain.Product;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {

    private Product product;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void onNotificationReceived(Product product) {
        System.out.println("************************************" + product + "************************************");
        this.product = product;
    }

    public Product getProduct(){
        return product;
    }

}
