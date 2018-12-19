package br.com.desafio.viewModel;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.desafio.controle.UsuarioControle;
import br.com.desafio.dominio.Usuario;

@ManagedBean(name = "usuarioViewModel")
public class UsuarioViewModel {

	private List<Usuario> usuarios = new UsuarioControle().listarTodos();

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
