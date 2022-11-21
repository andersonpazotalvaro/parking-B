package co.smart.parking.rabbitmq.adaptador;

import co.smart.parking.gson.GsonAdaptador;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EscritorMensaje implements GsonAdaptador {

    private final RabbitTemplate rabbitPlantilla;
    private final EscritorConfig escritorConfig;

    public EscritorMensaje(RabbitTemplate rabbitPlantilla, EscritorConfig escritorConfig) {
        this.rabbitPlantilla = rabbitPlantilla;
        this.escritorConfig = escritorConfig;
    }

    public void escribirMensaje(Object objeto) {
        var mensaje = toJson(objeto);
        rabbitPlantilla.convertAndSend(escritorConfig.queue().getName(), mensaje);
    }
}


