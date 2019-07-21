package beto.banco.credito.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import beto.banco.credito.entity.ProductoTO;
import beto.banco.credito.repositorio.ProductoRepository;
import beto.banco.credito.service.ProductoService;
import beto.banco.credito.solicitud.evento.SolicitudCreadoEvento;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsuarioProductoRabbitListener {

	@Autowired private ApplicationEventPublisher publisher;
	@Autowired private ObjectMapper objectMapper;
	@Autowired private ProductoService productoService;
	
	@SneakyThrows
	@RabbitListener(queues = {"#{usuarioCreadoQueue.name}"})
	public void handleUsuarioCreadoEvento(String message) {
		
		log.info("rabbit listener Obteniendo Solicitud");
		
		SolicitudCreadoEvento solicitud = objectMapper.readValue(message, SolicitudCreadoEvento.class);
		log.info("Solicitud recuperada " + solicitud.toString());
		
		log.info(" Guardando el producto del cliente ");
		productoService.altaProducto(llenarProducto(solicitud));
		
	}
	
	private ProductoTO llenarProducto(SolicitudCreadoEvento solicitud) {
		ProductoTO producto = new ProductoTO();
		try {
						
			producto.setIdProducto(nexUserId());
			producto.setClaveProducto(solicitud.getClaveProducto());
			producto.setDescripcion(solicitud.getDescripcion());
			producto.setClaveUsuario(solicitud.getClaveUsuario());
			
		}catch(RuntimeException e) {
			log.info("Problema al obtener los datos para el producto " + e.getStackTrace());
		}
		return producto;
	}
	
	public static int nexUserId() {
		return (int) (Math.random() * 1000000L);
	}
}
