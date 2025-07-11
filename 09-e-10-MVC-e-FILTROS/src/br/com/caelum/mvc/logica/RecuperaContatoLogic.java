package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RecuperaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));

		// busca a conexão pendurada na requisição via FiltroConexao
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		Contato contato = dao.pesquisar(id);

		System.out.println("Recuperando contato ...");

		request.setAttribute("contato", contato);

		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}

}
