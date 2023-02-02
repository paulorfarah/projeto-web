package br.udesc.ceavi.eso.dsw.primeiroprojeto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.udesc.ceavi.eso.dsw.primeiroprojeto.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
