package br.udesc.ceavi.eso.dsw.primeiroprojeto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {
	
	@GetMapping("/inicio")
	public String inicio(@RequestParam(value="nome", defaultValue="world") String nome) {
		return String.format("Olá, %s!", nome); 
	}
	
	@GetMapping(path="/bean")
	public PrimeiroBean bean() {
		return new PrimeiroBean("Olá Mundo!");
	}
	
	@GetMapping(path="/var-path/{nome}")
	public PrimeiroBean variavelPath(@PathVariable String nome) {
		return new PrimeiroBean(String.format("Olá, %s", nome));
	}

}
