package co.smart.parking.rabbitmq.adaptador;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscritorConfig {

    @Value("${parking.queue}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }
}
