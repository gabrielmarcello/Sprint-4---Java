package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Guincho;

public interface IGuinchoDAO {
	
	public void inserir(Guincho guincho) throws SQLException;
	public ArrayList<Guincho> listar() throws SQLException;
	public Guincho buscarPorId(int id) throws SQLException;
	public void atualizar(Guincho guincho, int id) throws SQLException;
	public void deletar(int id) throws SQLException;

}
