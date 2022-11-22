package co.smart.parking.rabbitmq.adaptador;

import co.smart.parking.gson.GsonAdaptador;
import co.smart.parking.vehiculo.modelo.dominio.VehiculoMovimiento;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OyenteMensaje implements GsonAdaptador {
    
    //@RabbitListener(queues = "${parking.queue}")
    public void recibirMensaje(String mensaje) {

        try {
            var vehiculoMovimiento = fromJson(mensaje, VehiculoMovimiento.class);
            System.out.println("Mensaje: " + mensaje);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
