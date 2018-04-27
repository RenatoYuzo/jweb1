package com.htcursos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.htcursos.model.Cliente;
import com.htcursos.repository.ClienteRepository;
import com.htcursos.util.JsonUtil;

// Mapeando "endpoint"
@WebServlet("/clientes")
public class ClienteController extends HttpServlet{
	
	ClienteRepository clienteRepository = new ClienteRepository();
	Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Buscar todos os clientes cadastrados
		List<Cliente> clientes = clienteRepository.buscarTodos();
		
		// Enviar resposta com a lista de clientes (Java) convertida para JSON
		resp.getWriter().print(gson.toJson(clientes));
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		// Converter o json para objeto Cliente
		Cliente cliente = gson.fromJson(json.toString(), Cliente.class);
		
		if(clienteRepository.cadastrar(cliente)) {
			// Cliente foi cadastrado com sucesso
			resp.getWriter().println("Cliente foi cadastrado com sucesso");
		}else {
			// Erro ao cadastrar cliente
			resp.getWriter().println("Erro ao cadastrar cliente");
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		// Converter o json para objeto Cliente
		Cliente cliente = gson.fromJson(json.toString(), Cliente.class);
		
		if(clienteRepository.atualizar(cliente)) {
			// Cliente foi cadastrado com sucesso
			resp.getWriter().println("Cliente foi atualizado com sucesso");
		}else {
			// Erro ao cadastrar cliente
			resp.getWriter().println("Erro ao atualizar cliente");
		}
		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = JsonUtil.lerJson(req.getReader());
		
		// Converter o json para objeto Cliente
		Cliente cliente = gson.fromJson(json.toString(), Cliente.class);
		
		if(clienteRepository.deletar(cliente.getId())) {
			// Cliente foi cadastrado com sucesso
			resp.getWriter().println("Cliente foi removido com sucesso");
		}else {
			// Erro ao cadastrar cliente
			resp.getWriter().println("Erro ao remover cliente");
		}
		
	}
}
