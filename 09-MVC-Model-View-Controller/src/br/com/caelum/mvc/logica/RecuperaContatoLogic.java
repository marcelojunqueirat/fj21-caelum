package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RecuperaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));

		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisar(id);

		System.out.println("Recuperando contato ...");

		request.setAttribute("contato", contato);

		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}

}
