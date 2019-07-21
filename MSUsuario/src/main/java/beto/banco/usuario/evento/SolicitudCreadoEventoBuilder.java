package beto.banco.usuario.evento;

import beto.banco.usuario.entity.SolicitudTO;

public class SolicitudCreadoEventoBuilder {

	public static SolicitudCreadoEvento build(SolicitudTO solicitud) {
		return SolicitudCreadoEvento.builder()
				.claveUsuario(solicitud.getClaveUsuario())
				.nombre(solicitud.getNombre())
				.apellidoMaterno(solicitud.getApellidoMaterno())
				.apellidoPaterno(solicitud.getApellidoPaterno())
				.direccion(solicitud.getDireccion())
				.correo(solicitud.getCorreo())
				.telefonoCelular(solicitud.getTelefonoCelular())
				.claveProducto(solicitud.getClaveProducto())
				.descripcion(solicitud.getDescripcion())
				.build();
	}
}
