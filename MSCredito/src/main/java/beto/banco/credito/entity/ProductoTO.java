package beto.banco.credito.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "Producto")
public class ProductoTO {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	private String claveProducto;
	
	private int claveUsuario;
	private String descripcion;
	
	/**
	 * 1= tiene debito
	 * 2=tiene credito
	 * 3=exito
	 */
	
	private String status;
	
}
