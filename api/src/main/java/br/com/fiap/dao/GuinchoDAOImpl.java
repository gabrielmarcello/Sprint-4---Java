package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.interfaces.IGuinchoDAO;
import br.com.fiap.beans.Guincho;
import br.com.fiap.conexoes.ConexaoFactory;

public class GuinchoDAOImpl implements IGuinchoDAO{

private Connection connection;
	
	public GuinchoDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}

	public void inserir(Guincho guincho) throws SQLException {
		try {
			String sql = "INSERT INTO guincho (telefone_guincho, tipo_guincho, capacidadeelevacao_guincho, velocidadeelevacao_guincho) VALUES(?, ?, ? ,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, guincho.getTelefone());
			statement.setString(2, guincho.getTipoGuincho());
			statement.setInt(3, guincho.getCapacidadeElevacao());
			statement.setInt(4, guincho.getVelocidadeElevacao());
			statement.execute();
			System.out.println("Cliente inserido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Guincho> listar() throws SQLException {
		try {
			ArrayList<Guincho> guinchos = new ArrayList<Guincho>();
			String sql = "SELECT * FROM guincho";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_guincho");
				int telefone = resultSet.getInt("telefone_guincho");
				String tipo = resultSet.getString("tipo_guincho");
				int capacidadeElevacao = resultSet.getInt("capacidadeelevacao_guincho");
				int velocidadeelevacao_guincho = resultSet.getInt("velocidadeelevacao_guincho");
				
				Guincho guincho = new Guincho(id, telefone, tipo, capacidadeElevacao, velocidadeelevacao_guincho);
				guinchos.add(guincho);
			}
			return guinchos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar clientes");
		}
		return null;
	}

	public Guincho buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM guincho WHERE id_guincho = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int id1 = resultSet.getInt("id_guincho");
				int telefone = resultSet.getInt("telefone_guincho");
				String tipo = resultSet.getString("tipo_guincho");
				int capacidadeElevacao = resultSet.getInt("capacidadeelevacao_guincho");
				int velocidadeelevacao_guincho = resultSet.getInt("velocidadeelevacao_guincho");
				
				Guincho guincho = new Guincho(id1, telefone, tipo, capacidadeElevacao, velocidadeelevacao_guincho);
				
				return guincho;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar guincho");
		}
		return null;
	}
	
	
	public void atualizar(Guincho guincho, int id) throws SQLException { //ver isso aq
		String sql = "UPDATE cliente SET telefone_guincho = ?, tipo_guincho = ?, capacidadeelevacao_guincho = ?, velocidadeelevacao_guincho = ? WHERE id_guincho = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, guincho.getTelefone());
			ps.setString(2, guincho.getTipoGuincho());
			ps.setInt(3, guincho.getCapacidadeElevacao());
			ps.setInt(4, guincho.getVelocidadeElevacao());
			ps.setInt(5, id);
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

	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM guincho WHERE id_guincho = ?";
		
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
