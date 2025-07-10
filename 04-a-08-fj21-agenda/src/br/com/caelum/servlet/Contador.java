package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class Contador extends HttpServlet {

	// variavel de instância
	// MÁ PRÁTICA: evitar usar atributos compartilhados, contador apenas de exemplo
	// (pág 88)
	private int contador = 0;

	// init e destroy são opcionais a sobrescrita, o método pai já fez o trabalho de
	// inicializar/destruir, mas pode ser sobrescrito para algum processamento
	// especifico da servlet.
	@Override
	public void init() throws ServletException {
		super.init();
		log("Iniciando a Servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo	a Servlet");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// a cada requisição a mesma variável é incrementada
		contador++;

		// recebe o writer
		PrintWriter out = response.getWriter();

		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Contador	agora	é:	" + contador);
		out.println("</body>");
		out.println("</html>");
	}

}
