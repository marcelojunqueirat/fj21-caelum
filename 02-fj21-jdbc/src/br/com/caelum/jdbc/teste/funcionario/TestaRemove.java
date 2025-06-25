package br.com.caelum.jdbc.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaRemove {

	public static void main(String[] args) {
		FuncionarioDao dao = new FuncionarioDao();

		// Garante autenticação antes de poder remover dados
		String usuario = "marcelo_";
		String senha = "1234567";
		Funcionario funcionario = dao.autenticar(usuario, senha);

		if (funcionario != null) {
			System.out.println("Login bem-sucedido!");
			System.out.println("Bem-vindo, " + funcionario.getNome() + "\n");

			Funcionario funcionarioAExcluir = dao.pesquisar(7);
			System.out.println("Removendo...");

			dao.remove(funcionarioAExcluir);
			System.out.println("Removido!");

		} else {
			System.out.println("Usuário ou senha inválidos.");
		}
	}
}
