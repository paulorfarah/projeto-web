package br.udesc.ceavi.eso.dsw.primeiroprojeto.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import br.udesc.ceavi.eso.dsw.primeiroprojeto.jpa.UsuarioRepository;

@RestController
public class UsuarioResource {
	
	private UsuarioRepository repository;
	
	public UsuarioResource(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user){
		Usuario savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users")
	public List<Usuario> allUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Usuario getUser(@PathVariable int id) throws Exception{
		Optional<Usuario> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new Exception("Erro: id do usuário não encontrado: " + id);
		}
		
		//Usuario entityModel = EntityModel.of(user.get());
		
//		return entityModel;
		return user.get();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

}
