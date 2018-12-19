package br.com.desafio.dominio.dao;


import br.com.desafio.dominio.Usuario;

public class UsuarioDao extends DaoGeneric<Usuario>{

	public UsuarioDao() {
		super();
		classPersistence = Usuario.class;
	}
}
