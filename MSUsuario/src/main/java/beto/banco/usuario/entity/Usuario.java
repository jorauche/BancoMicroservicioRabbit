package beto.banco.usuario.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Usuario {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3932188087109663639L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claveUsuario;
	
	private String nombre;
	
	private String apellidoMaterno;
	
	private String apellidoPaterno;
	
	private String direccion;
	
	private String correo;
	
	private long telefonoCelular;
	
	private String rfc;

}
