package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Orcamento;
import br.com.fiap.dao.OrcamentoDAOImpl;

public class OrcamentoBO {
	
	OrcamentoDAOImpl orcamentoDAO = null;
	
	public void inserirBO(Orcamento orcamento) throws ClassNotFoundException, SQLException {
		
		OrcamentoDAOImpl orcamentoDAO = new OrcamentoDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		orcamentoDAO.inserir(orcamento);
	}
	
	public void atualizarBO(Orcamento orcamento, int id) throws ClassNotFoundException, SQLException {
		
		OrcamentoDAOImpl orcamentoDAO = new OrcamentoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		orcamentoDAO.atualizar(orcamento, id);
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		OrcamentoDAOImpl orcamentoDAO = new OrcamentoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		orcamentoDAO.deletar(id);
	}
	
	public ArrayList<Orcamento> listarBO() throws ClassNotFoundException, SQLException{
		
		OrcamentoDAOImpl orcamentoDAO = new OrcamentoDAOImpl();
		return (ArrayList<Orcamento>) orcamentoDAO.listar();
		
	}
	
	

}
