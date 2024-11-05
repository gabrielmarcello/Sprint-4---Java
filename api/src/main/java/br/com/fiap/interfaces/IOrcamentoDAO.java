package br.com.fiap.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Orcamento;

public interface IOrcamentoDAO {
	
	public void inserir(Orcamento orcamento) throws SQLException;
	public ArrayList<Orcamento> listar() throws SQLException;
	public Orcamento buscarPorId(int id) throws SQLException;
	public void atualizar(Orcamento orcamento, int id) throws SQLException;
	public void deletar(int id) throws SQLException;

}
