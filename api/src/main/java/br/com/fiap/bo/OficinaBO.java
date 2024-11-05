package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Oficina;
import br.com.fiap.dao.OficinaDAOImpl;

public class OficinaBO {
	
	OficinaDAOImpl oficiaDAO = null;
	
	public void inserirBO(Oficina oficina) throws ClassNotFoundException, SQLException {
		
		OficinaDAOImpl oficinaDAO = new OficinaDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		oficinaDAO.inserir(oficina);
	}
	
	public ArrayList<Oficina> listarBO() throws ClassNotFoundException, SQLException{
		
		OficinaDAOImpl oficinaDAO = new OficinaDAOImpl();
		return (ArrayList<Oficina>) oficinaDAO.listar();
		
	}
	
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
		
		OficinaDAOImpl oficinaDAO = new OficinaDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		oficinaDAO.deletar(id);
	}

}
