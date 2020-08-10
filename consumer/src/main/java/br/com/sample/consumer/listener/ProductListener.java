package br.com.sample.consumer.listener;

import br.com.sample.consumer.config.RabbitMQConfig;
import br.com.sample.consumer.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductListener {

    private Product product;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void onNotificationReceived(Product product) {
        log.info("Receiving product event: "+ product);
        this.product = product;
    }

    public Product getProduct(){
        return product;
    }

}
