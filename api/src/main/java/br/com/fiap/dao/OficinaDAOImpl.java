package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.interfaces.IOficinaDAO;
import br.com.fiap.beans.Oficina;
import br.com.fiap.conexoes.ConexaoFactory;

public class OficinaDAOImpl implements IOficinaDAO{
	
	private Connection connection;
	
	public OficinaDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}

	public void inserir(Oficina oficina) throws SQLException {
		try {
			String sql = "INSERT INTO oficina (endereco_oficina, cep_oficina, telefone_oficina) VALUES(?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, oficina.getEndereco());
			statement.setInt(2, oficina.getCep());
			statement.setInt(3, oficina.getTelefone());
			statement.execute();
			System.out.println("Oficina inserido");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
	}

	public ArrayList<Oficina> listar() throws SQLException {
		try {
			ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
			String sql = "SELECT * FROM oficina";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_oficina");
				String endereco = resultSet.getString("endereco_oficina");
				int cep = resultSet.getInt("cep_oficina");
				int telefone = resultSet.getInt("telefone_oficina"); //acesso pelo label
				
				Oficina oficina = new Oficina(id, endereco, telefone, cep);
			}
			return oficinas;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar clientes");
		}
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
		return null;
	}

	public Oficina buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM oficina WHERE id_oficina = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int ID = resultSet.getInt("id_oficina");
				String endereco = resultSet.getString("endereco_oficina");
				int cep = resultSet.getInt("cep_oficina");
				int telefone = resultSet.getInt("telefone_oficina"); //acesso pelo label
				
				//criar um objeto de Oficina
				Oficina oficina = new Oficina(ID, endereco, telefone, cep);
				
				return oficina;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar Oficina");
		}
		return null;
	}

	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM oficina WHERE id_oficina = ?";
		
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
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
		
	}

}