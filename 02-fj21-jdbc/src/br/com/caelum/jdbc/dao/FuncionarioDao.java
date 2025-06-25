package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;
import br.com.caelum.utils.Utils;

public class FuncionarioDao {
	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insere(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios (nome, usuario, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());

			String senhaCriptografada = Utils.hashSenha(funcionario.getSenha());
			stmt.setString(3, senhaCriptografada);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}

	public Funcionario autenticar(String usuario, String senha) {
		String sql = "SELECT * FROM funcionarios WHERE usuario = ? AND senha = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario);

			String senhaHash = Utils.hashSenha(senha);
			stmt.setString(2, senhaHash);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));

				rs.close();
				stmt.close();
				return funcionario;
			}

			rs.close();
			stmt.close();
			return null;
		} catch (SQLException e) {
			throw new DAOException("Erro ao autenticar usuário", e);
		}
	}

	public List<Funcionario> getLista() {
		String sql = "select * from funcionarios";
		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));

				funcionarios.add(funcionario);
			}

			rs.close();
			stmt.close();
			return funcionarios;
		} catch (SQLException e) {
			throw new DAOException("Erro ao listar usuários", e);
		}
	}

	public void altera(Funcionario funcionario) {
		String sql = "UPDATE funcionarios SET nome = ?, usuario = ?, senha = ? WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());

			String senhaCriptografada = Utils.hashSenha(funcionario.getSenha());
			stmt.setString(3, senhaCriptografada);
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException | NullPointerException e) {
			throw new DAOException("Erro ao atualizar dados.", e);
		}
	}

	public void remove(Funcionario funcionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionarios where id=?");
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException | NullPointerException e) {
			throw new DAOException("Erro ao excluir dados.", e);
		}
	}

	public Funcionario pesquisar(int id) {
		String sql = "select * from funcionarios where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			Funcionario funcionario = null;
			if (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
			}

			rs.close();
			stmt.close();
			return funcionario;
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar contato com ID " + id, e);
		}
	}
}
