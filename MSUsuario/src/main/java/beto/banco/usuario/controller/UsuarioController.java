package beto.banco.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beto.banco.usuario.entity.SolicitudTO;
import beto.banco.usuario.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/usuario/solicitud")
public class UsuarioController {

	@Autowired private UsuarioService usuarioService;
	
	@PostMapping(path="/alta")
	public String postUser(@RequestBody SolicitudTO solicitud) {
		usuarioService.registraUsuario(solicitud);
		log.info("request " + solicitud.toString());
		return "Solictud  CLiente dado de alta";
	}
}
