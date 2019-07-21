package beto.banco.credito.observer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import beto.banco.credito.entity.ProductoTO;
import beto.banco.credito.evento.ProductoCreadoEvento;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductoCreadoListener {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private  FanoutExchange fanoutExchange;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	@SneakyThrows
	@EventListener
	public void handleProductoCreadoEvento(ProductoCreadoEvento producto) {
		
		log.info("Enviando producto creado {} " , fanoutExchange.getName());
		
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", 
				objectMapper.writeValueAsString(producto));
	}
}
