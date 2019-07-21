package beto.banco.notificacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import beto.banco.notificacion.entity.NotificacionTO;
import beto.banco.notificacion.evento.NotificacionCreadoEventoBuilder;
import beto.banco.notificacion.repositorio.NotificacionRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificacionService {

	@Autowired NotificacionRepository repository;
	
	@Autowired private ApplicationEventPublisher publisher;
	
	public void guardarNotificacion(NotificacionTO notificacion) {
		log.info("Se guarda la notificacion");
		
		repository.save(notificacion);
		
		log.info("----------------Cliente----------------------");
		log.info("Publish notificacion evento al cliente ");
		publisher.publishEvent(NotificacionCreadoEventoBuilder.build(notificacion));
		
		
	}
}
