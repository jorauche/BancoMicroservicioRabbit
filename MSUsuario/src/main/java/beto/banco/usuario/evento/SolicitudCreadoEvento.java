package beto.banco.usuario.evento;

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
public class SolicitudCreadoEvento {

	private int claveUsuario;
	
	private String nombre;
	
	private String apellidoMaterno;
	
	private String apellidoPaterno;
	
	private String direccion;
	
	private String correo;
	
	private long telefonoCelular;
	
	private String claveProducto;
	
	private String descripcion;
	

}
