package br.com.desafio;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desafio.controle.UsuarioControle;
import br.com.desafio.dominio.Usuario;

/**
 * Servlet implementation class Desafio
 */
@WebServlet("/Desafio")
public class Desafio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Desafio() {
        super();
        // TODO Auto-generated constructor stub
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Usuario>> listar() {

		List<Usuario> listUsuarios = new UsuarioControle().listarTodos();

		return ResponseEntity.ok().body(listUsuarios);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@GET
	@Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Usuario> findById(@PathVariable String id) {
		Planeta objPlaneta = service.findById(id);
		return ResponseEntity.ok().body(objPlaneta);
	}

	@GET
	@Path("/find/{name}")
	 @Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Usuario> findByName(@PathVariable String name) {
		Usuario objPlaneta = new UsuarioControle().buscarPorNome(name);
		return ResponseEntity.ok().body(objPlaneta);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Void> inserir(@RequestBody Usuario objUsuario) {

		new UsuarioControle().inserir(objUsuario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUsuario.getId())
				.toUri();

		// retorna uma uri com o id
		return ResponseEntity.created(uri).build();
	}

}
