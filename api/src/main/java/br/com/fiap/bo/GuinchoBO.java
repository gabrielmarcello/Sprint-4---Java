package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Guincho;
import br.com.fiap.dao.GuinchoDAOImpl;

public class GuinchoBO {
	
	GuinchoDAOImpl guinchoDAO = null;
	
	public void inserirBO(Guincho guincho) throws ClassNotFoundException, SQLException {
		
		GuinchoDAOImpl guinchoDAO = new GuinchoDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		guinchoDAO.inserir(guincho);
	}
	
	public ArrayList<Guincho> listarBO() throws ClassNotFoundException, SQLException{
		
		GuinchoDAOImpl guinchoDAO = new GuinchoDAOImpl();
		return (ArrayList<Guincho>) guinchoDAO.listar();
		
	}
	
	public Guincho buscarPorIdBO(int id) throws ClassNotFoundException, SQLException{
		
		GuinchoDAOImpl guinchoDAO = new GuinchoDAOImpl();
		
		return guinchoDAO.buscarPorId(id);
	}
	
	public void atualizarBO(Guincho guincho, int id) throws ClassNotFoundException, SQLException {
		
		GuinchoDAOImpl guinchoDAO = new GuinchoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		guinchoDAO.atualizar(guincho, id);
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		GuinchoDAOImpl guinchoDAO = new GuinchoDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		guinchoDAO.deletar(id);
	}

}
