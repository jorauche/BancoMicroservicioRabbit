package beto.banco.credito.evento;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductoCreadoEvento {

	
	private String claveProducto;
	
	private int claveUsuario;
	private String descripcion;
	private String estatus;
	private String cuenta;
}