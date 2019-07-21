package beto.banco.credito.evento;

import beto.banco.credito.entity.ProductoTO;

public class ProductoCreadoEventoBuilder {
	
	public static ProductoCreadoEvento build(ProductoTO producto) {
		
		return ProductoCreadoEvento.builder()
				.claveProducto(producto.getClaveProducto())
				.claveUsuario(producto.getClaveUsuario())
				.descripcion(producto.getDescripcion())
				.estatus(producto.getStatus())
				.build();
	}

}
