package beto.banco.notificacion.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionCreadoEvento {

	private String idNotificacion;
	private String descripcion;
	private String estatus;
}
