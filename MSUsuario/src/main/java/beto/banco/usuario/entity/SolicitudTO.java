package beto.banco.usuario.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SolicitudTO implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2432856159868278399L;

	private int claveUsuario;
	
	@NotBlank(message="La nombre es requerido para continuar con el proceso.")
	private String nombre;
	
	@NotBlank(message="La apellidoMaterno es requerido para continuar con el proceso.")
	private String apellidoMaterno;
	
	@NotBlank(message="La apellidoPaterno es requerido para continuar con el proceso.")
	private String apellidoPaterno;
	
	@NotBlank(message="La direccion es requerido para continuar con el proceso.")
	private String direccion;
	
	private String correo;
	
	private long telefonoCelular;
	
	@NotBlank(message="La claveProducto es requerido para continuar con el proceso.")
	private String claveProducto;
	
	private String descripcion;
	
	private String rfc;

}
