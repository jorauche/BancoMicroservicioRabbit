package beto.banco.notificacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import beto.banco.notificacion.entity.NotificacionTO;

public interface NotificacionRepository  extends JpaRepository<NotificacionTO, String>{
	

}
