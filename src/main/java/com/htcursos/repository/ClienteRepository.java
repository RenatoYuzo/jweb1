package com.htcursos.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.htcursos.connection.ConnectionFactory;
import com.htcursos.model.Cliente;
import com.mysql.cj.jdbc.PreparedStatement;

public class ClienteRepository {

	/**
	 * CRUD C - Create - Criar R - Retriave - Buscar U - Update - Atualizar D -
	 * Delete - Deletar
	 */

	Connection con;

	public ClienteRepository() {
		con = ConnectionFactory.getConnection();
	}

	public List<Cliente> buscarTodos() {
		// Criando uma lista de clientes vazia
		List<Cliente> clientes = new ArrayList<>();

		// Montar o string sql
		String sql = "select * from cliente";

		try {
			// Preparar o sql
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setId(resultado.getInt("id"));

				clientes.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return clientes;

	}

	public Boolean cadastrar(Cliente cliente) {

		String sql = "insert into cliente (nome,email,cpf) values(?,?,?)";

		try {
			// Pegando o PreparedStatement
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getEmail());
			preparador.setString(3, cliente.getCpf());
			preparador.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Boolean atualizar(Cliente cliente) {

		String sql = "update cliente set nome=?, email=?, cpf=? where id=?";

		try {
			// Pegando o PreparedStatement
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getEmail());
			preparador.setString(3, cliente.getCpf());
			preparador.setInt(4, cliente.getId());
			preparador.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public Boolean deletar(Integer id) {

		String sql = "delete from cliente where id=?";

		try {
			// Pegando o PreparedStatement
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			preparador.setInt(1, id);
			preparador.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
