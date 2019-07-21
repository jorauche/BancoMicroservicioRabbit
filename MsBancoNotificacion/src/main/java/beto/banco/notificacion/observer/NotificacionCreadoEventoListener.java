package beto.banco.notificacion.observer;



import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import beto.banco.notificacion.evento.NotificacionCreadoEvento;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificacionCreadoEventoListener {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private  FanoutExchange fanoutExchange;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	@SneakyThrows
	@EventListener
	public void handleNotificacionCreadoEvento(NotificacionCreadoEvento notificacion) {
		
		log.info("Enviando Notificacion Creada a {}" , fanoutExchange.getName());
		
		rabbitTemplate.convertAndSend(fanoutExchange.getName(), "",
				objectMapper.writeValueAsString(notificacion));
	}
	
}
