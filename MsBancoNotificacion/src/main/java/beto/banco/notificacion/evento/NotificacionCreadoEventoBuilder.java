package beto.banco.notificacion.evento;

import beto.banco.notificacion.entity.NotificacionTO;

public class NotificacionCreadoEventoBuilder {

	public static NotificacionCreadoEvento build(NotificacionTO notificacion) {
		return NotificacionCreadoEvento.builder()
				.idNotificacion(notificacion.getIdNotificacion())
				.descripcion(notificacion.getDescripcion())
				.estatus(notificacion.getEstatus())
				.build();
	}
}
