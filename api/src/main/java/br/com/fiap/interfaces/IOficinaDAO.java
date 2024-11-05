package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Oficina;

public interface IOficinaDAO {
	
	public void inserir(Oficina oficina) throws SQLException;
	public ArrayList<Oficina> listar() throws SQLException;
	public Oficina buscarPorId(int id) throws SQLException;
	public void deletar(int id) throws SQLException;

}
