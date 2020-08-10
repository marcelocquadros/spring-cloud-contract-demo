package br.com.sample.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public static final String EXCHANGE = "product-exchange";

    public static final String ROUTE_KEY = "product.created";

    public static final String QUEUE = "product.created";

    @Bean
    TopicExchange exchange() {
        return  new TopicExchange(EXCHANGE);
    }


    @Bean
    Queue queueLongTime() {
        return new Queue(QUEUE);
    }


    @Bean
    Binding bindingQueue(Queue queueLongTime, TopicExchange exchange) {
        return BindingBuilder.bind(queueLongTime).to(exchange).with(ROUTE_KEY);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}