package br.com.fiap.bo;

import java.sql.SQLException;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.VeiculoDAOImpl;

public class VeiculoBO {
	
	VeiculoDAOImpl veiculoDAO = null;
	
	public void inserirBO(Veiculo veiculo) throws ClassNotFoundException, SQLException {
		
		VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		veiculoDAO.inserir(veiculo);
	}
	
	public Veiculo buscarPorPlacaBO(String placa) throws SQLException, ClassNotFoundException {
		
		VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
		
		return veiculoDAO.buscarPorPlaca(placa);
		
	}
	
	public void atualizarBO(Veiculo veiculo, String placa) throws ClassNotFoundException, SQLException {
		
		VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		veiculoDAO.atualizar(veiculo, placa);
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		VeiculoDAOImpl veiculoDAO = new VeiculoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		veiculoDAO.deletar(id);
	}

}
