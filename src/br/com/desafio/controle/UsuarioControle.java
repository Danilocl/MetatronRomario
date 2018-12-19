package br.com.desafio.controle;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.dominio.Usuario;
import br.com.desafio.dominio.dao.UsuarioDao;

public class UsuarioControle implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioDao dao;

	public UsuarioControle() {
		dao = new UsuarioDao();
	}

	public void inserir(Usuario usuario) {
		dao.persist(usuario);
	}

	public void modificar(Usuario usuario) {
		dao.merge(usuario);
	}

	public List<Usuario> listarTodos() {
		return dao.findAll();
	}

	public Usuario buscarPorId(int id) {
		return dao.getById(id);
	}

	public Usuario buscarPorId(Usuario usuario) {
		return dao.getById(usuario.getId());
	}

}
