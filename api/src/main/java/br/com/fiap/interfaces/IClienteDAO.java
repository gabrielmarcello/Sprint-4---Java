package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Cliente;

public interface IClienteDAO {
	
	public void inserir(Cliente cliente) throws SQLException;
	public ArrayList<Cliente> listar() throws SQLException;
	public Cliente buscarPorCpf(int cpf) throws SQLException;
	public void atualizar(Cliente cliente, int id) throws SQLException;
	public void deletar(int id) throws SQLException;

}
