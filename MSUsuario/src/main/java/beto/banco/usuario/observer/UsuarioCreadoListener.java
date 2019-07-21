package beto.banco.usuario.observer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import beto.banco.usuario.evento.SolicitudCreadoEvento;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsuarioCreadoListener {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private  FanoutExchange fanoutExchange;
	
	@Autowired
	private ObjectMapper ObjectMapper;
	
	@SneakyThrows
	@EventListener
	public void handleUsuarioCreadoEvento(SolicitudCreadoEvento solicitud) {
		log.info("Enviando Solicitud creado a {}" , fanoutExchange.getName());
		
		rabbitTemplate.convertAndSend(fanoutExchange.getName() , "",
				ObjectMapper.writeValueAsString(solicitud));
	}
	
}
