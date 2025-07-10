package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;

@WebServlet("/listarContato")
public class ListarContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContatoDao dao = new ContatoDao();
	
		request.setAttribute("contatos", dao.getLista());
		request.getRequestDispatcher("lista-contatos-com-displaytag.jsp").forward(request, response);
	}

}
