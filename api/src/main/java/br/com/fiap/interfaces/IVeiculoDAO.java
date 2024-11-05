package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Veiculo;

public interface IVeiculoDAO {
	
	public void inserir(Veiculo veiculo) throws SQLException;
	public ArrayList<Veiculo> listarVeiculosCliente(Cliente cliente) throws SQLException;
	public Veiculo buscarPorPlaca(String placa) throws SQLException;
	public void atualizar(Veiculo veiculo, String placa) throws SQLException;
	public void deletar(int id) throws SQLException;

}
