package beto.banco.notificacion.credito.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoCreadoEvento {

	
	private String claveProducto;
	
	private int claveUsuario;
	private String descripcion;
	private String estatus;
}
