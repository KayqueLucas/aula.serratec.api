package br.org.serratec.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.biblioteca.entities.Usuario;
import br.org.serratec.biblioteca.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		
		if (usuario == null) 
			return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
		else 
			return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		if(usuarioService.deleteById(id)) {
		return new ResponseEntity<>("Perfil apagado com sucesso",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Perfil não encontrado",HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
