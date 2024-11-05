package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAOImpl;

public class ClienteBO {
	
	ClienteDAOImpl clienteDAO = null;
	
	
	public void inserirBO(Cliente cliente) throws ClassNotFoundException, SQLException {
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		clienteDAO.inserir(cliente);
	}
	
	public void atualizarBO(Cliente cliente, int id) throws ClassNotFoundException, SQLException {
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		clienteDAO.atualizar(cliente ,id);
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		clienteDAO.deletar(id);
	}
	
	public ArrayList<Cliente> listarBO() throws ClassNotFoundException, SQLException{
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		return (ArrayList<Cliente>) clienteDAO.listar();
		
	}
	
	public Cliente buscarPorCpfBO(int cpf) throws ClassNotFoundException, SQLException{
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
		
		return clienteDAO.buscarPorCpf(cpf);
	}
}
