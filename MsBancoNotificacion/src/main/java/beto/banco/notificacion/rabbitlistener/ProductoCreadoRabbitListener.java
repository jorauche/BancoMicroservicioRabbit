package beto.banco.notificacion.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import beto.banco.notificacion.credito.evento.ProductoCreadoEvento;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductoCreadoRabbitListener {
	
	@Autowired private ApplicationEventPublisher publisher;
	@Autowired private ObjectMapper objectMapper;

	@SneakyThrows
	@RabbitListener(queues = {"#{productoCreadoQueue.name}"})
	public void handleProductoCreadoEvento(String message) {
		log.info("Rabbit listener obteniendo el producto con su estatus");
		
		ProductoCreadoEvento producto = objectMapper.readValue(message, ProductoCreadoEvento.class);
		
		log.info("Producto informado {}", producto.toString() );
		
		
	}
	
}
