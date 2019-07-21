package beto.banco.credito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beto.banco.credito.entity.ProductoTO;
import beto.banco.credito.evento.ProductoCreadoEventoBuilder;
import beto.banco.credito.repositorio.ProductoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductoService {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	ProductoRepository productoRepository;
	
	public void altaProducto(ProductoTO producto) {
		log.info("Inicia altaProducto()");
		List<ProductoTO> produc = productoRepository.productosUsuario(producto.getClaveUsuario());
		log.info("Lista de productos de inicio" + produc.toString());
	
		if(produc.isEmpty()) {
			log.info("Primer producto del cliente");
			producto.setCuenta("129756435728735");
			productoRepository.save(producto);
			producto.setStatus("3");
		}else {
			log.info("El tiene algun producto el cliente, se valida");
			for(ProductoTO p : produc) {
				if(p.getClaveProducto().equals("1") && producto.getClaveProducto().equals("1")  ) {
					log.info("Ya cuentas con una cuenta de debito");
					producto.setStatus("1");
				}else if( p.getClaveProducto().equals("2") && producto.getClaveProducto().equals("2")) {
					log.info("Ya cuenta con la de credito");
					producto.setStatus("2");
				}
				else {
					log.info("Tenemos nuevo producto ");
					productoRepository.save(producto);
					producto.setStatus("3");
				}
			}
		}
		
		log.info("publishing  Pruducto Created Event");
		publisher.publishEvent(ProductoCreadoEventoBuilder.build(producto));
		
	}
}
