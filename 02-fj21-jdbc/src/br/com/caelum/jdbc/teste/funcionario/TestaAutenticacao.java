package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaAutenticacao {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();

		String usuario = "marcelo_123";
		String senha = "123456";

		Funcionario funcionario = dao.autenticar(usuario, senha);

		if (funcionario != null) {
			System.out.println("Login bem-sucedido!");
			System.out.println("Bem-vindo, " + funcionario.getNome());
		} else {
			System.out.println("Usuário ou senha inválidos.");
		}

	}

}
