package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaAltera {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();

		// Garante autenticação antes de poder alterar dados
		String usuario = "marcelo_1234";
		String senha = "1234567";
		Funcionario funcionario = dao.autenticar(usuario, senha);

		if (funcionario != null) {
			System.out.println("Login bem-sucedido!");
			System.out.println("Bem-vindo, " + funcionario.getNome() + "\n");
			System.out.println("Alterando...");
				
			funcionario.setNome("Marcelo Teste Alterado");
			funcionario.setUsuario("marcelo_12345");
			funcionario.setSenha("12345678");

			dao.altera(funcionario);
			System.out.println("Alterado!");

		} else {
			System.out.println("Usuário ou senha inválidos.");
		}

	}
}
