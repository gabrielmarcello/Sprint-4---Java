package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.fiap.interfaces.IOrcamentoDAO;
import br.com.fiap.beans.Oficina;
import br.com.fiap.beans.Orcamento;
import br.com.fiap.conexoes.ConexaoFactory;

public class OrcamentoDAOImpl implements IOrcamentoDAO{

	private Connection connection;
	private OficinaDAOImpl od;
	
	public OrcamentoDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
		od = new OficinaDAOImpl();
	}

	@Override
	public void inserir(Orcamento orcamento) throws SQLException {
		try {
			String sql = "INSERT INTO orcamento (valor_orcamento, data_orcamento, orcamento_fk_oficina) VALUES(?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, orcamento.getValorTotal());
			statement.setDate(2, orcamento.getData());
			statement.setInt(3, orcamento.getOficina().getId());
			statement.execute();
			System.out.println("Orcamento inserido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Orcamento> listar() throws SQLException {
		
		try {
			ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
			String sql = "SELECT * FROM orcamento";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_orcamento");
				float valor = resultSet.getFloat("valor_orcamento");
				Date data = resultSet.getDate("data_orcamento");
				int fk_oficina = resultSet.getInt("orcamento_fk_oficina");
				
				Oficina oficina = od.buscarPorId(fk_oficina);
				
				
				Orcamento orcamento = new Orcamento(id, data, valor, oficina);
				orcamentos.add(orcamento);
			}
			return orcamentos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar orcamentos");
		}
		return null;
	}

	@Override
	public Orcamento buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM orcamento WHERE id_orcamento = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int id1 = resultSet.getInt("id_orcamento");
				float valor = resultSet.getFloat("valor_orcamento");
				Date data = resultSet.getDate("data_orcamento");
				int fk_oficina = resultSet.getInt("orcamento_fk_oficina");
				
				Oficina oficina = od.buscarPorId(fk_oficina);
				
				Orcamento orcamento = new Orcamento(id1, data, valor, oficina);
				
				return orcamento;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar orcamento");
		}
		return null;
	}

	@Override
	public void atualizar(Orcamento orcamento, int id) throws SQLException { 
		String sql = "UPDATE orcamento SET valor_orcamento = ?, data_orcamento = ? WHERE id_orcamento = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setFloat(1, orcamento.getValorTotal());
			ps.setDate(2, orcamento.getData());
			ps.execute();
			System.out.println("Executado!");
			
		} catch (SQLException e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação UPTDATE! " + e.getStackTrace());
			}
		}
	}

	@Override
	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM orcamento WHERE id_orcamento = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Executado!");
		} catch (Exception e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação DELETE! " + e.getStackTrace());
			}
		}
	}	

}
