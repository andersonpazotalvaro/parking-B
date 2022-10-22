package co.smart.parking.rabbitmq.adaptador;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EscritorMensaje {

    private final RabbitTemplate rabbitPlantilla;

    private final EscritorConfig escritorConfig;

    public EscritorMensaje(RabbitTemplate rabbitPlantilla, EscritorConfig escritorConfig) {
        this.rabbitPlantilla = rabbitPlantilla;
        this.escritorConfig = escritorConfig;
    }

    public void escribirMensaje(Object mensaje) {
        rabbitPlantilla.convertAndSend(escritorConfig.queue().getName(),mensaje);
    }
}


