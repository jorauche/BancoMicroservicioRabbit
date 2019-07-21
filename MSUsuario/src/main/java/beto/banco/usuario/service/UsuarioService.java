package beto.banco.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beto.banco.usuario.entity.SolicitudTO;
import beto.banco.usuario.entity.Usuario;
import beto.banco.usuario.evento.SolicitudCreadoEventoBuilder;
import beto.banco.usuario.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public void registraUsuario(SolicitudTO solicitud) {
		log.info("Inicia registraUsuario()");
		
		Usuario usuario = new Usuario();
		usuario.setClaveUsuario(nexUserId());
		usuario.setNombre(solicitud.getNombre());
		usuario.setApellidoPaterno(solicitud.getApellidoPaterno());
		usuario.setApellidoMaterno(solicitud.getApellidoMaterno());
		usuario.setDireccion(solicitud.getDireccion());
		usuario.setCorreo(solicitud.getCorreo());
		usuario.setTelefonoCelular(solicitud.getTelefonoCelular());
		usuario.setRfc(solicitud.getRfc());
		solicitud.setClaveUsuario(usuario.getClaveUsuario());
		
		Usuario usuarioBD = usuarioRepository.getUsuario(solicitud.getRfc());
		
		if(usuarioBD != null && usuario.getRfc().equalsIgnoreCase(solicitud.getRfc())){
			log.info("Ya existe el usuario {}" , usuarioBD.getRfc()); 
		}else {
			usuarioRepository.save(usuario);
		}
		
		
		log.info("publishing User Created Event");
		
		if (solicitud.getClaveProducto().equals("1")) {
			solicitud.setDescripcion("DEBITO");
		}
		else if(solicitud.getClaveProducto().equals("2")) {
			solicitud.setDescripcion("CREDITO");
		}
		
		log.info("evento desde Usuario " + solicitud.toString());
		publisher.publishEvent(SolicitudCreadoEventoBuilder.build(solicitud));
	}
	
	public static int nexUserId() {
		return (int) (Math.random() * 1000000L);
	}
}
