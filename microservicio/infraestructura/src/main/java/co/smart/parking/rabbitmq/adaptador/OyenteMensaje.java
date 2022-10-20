package co.smart.parking.rabbitmq.adaptador;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OyenteMensaje {

    @RabbitListener(queues = "${parking.queue}")
    public void recibirMensaje(String mensaje) {

        try {
            System.out.println("Mensaje: " + mensaje);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
