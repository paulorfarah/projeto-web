package br.udesc.ceavi.eso.dsw.primeiroprojeto.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="O nome deve conter pelo menos 3 letras.")
	private String nome;
	
	public Usuario(){}
	
	public Usuario(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
