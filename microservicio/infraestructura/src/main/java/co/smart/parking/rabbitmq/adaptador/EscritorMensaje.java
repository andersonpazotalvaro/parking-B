package co.smart.parking.rabbitmq.adaptador;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EscritorMensaje {

    private final RabbitTemplate rabbitPlantilla;

    public EscritorMensaje(RabbitTemplate rabbitPlantilla) {
        this.rabbitPlantilla = rabbitPlantilla;
    }

    public void escribirMensaje() {
        
    }
}


