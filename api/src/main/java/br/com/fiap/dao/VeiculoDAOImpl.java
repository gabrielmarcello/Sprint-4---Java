package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.interfaces.IVeiculoDAO;
import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.conexoes.ConexaoFactory;

public class VeiculoDAOImpl implements IVeiculoDAO{
	
private Connection connection;
	
	public VeiculoDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}

	public void inserir(Veiculo veiculo) throws SQLException {
		try {
			String sql = "INSERT INTO veiculo (id_cliente, marca_veiculo, tipo_veiculo, modelo_veiculo, anoFabricacao_veiculo, placa_veiculo, quilometragem_veiculoi, fk_cliente) VALUES(?, ?, ?, ? ,? ,?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, veiculo.getId());
			statement.setString(2, veiculo.getMarca());
			statement.setString(3, veiculo.getTipo());
			statement.setString(4, veiculo.getModelo());
			statement.setInt(5, veiculo.getAnoFabricacao());
			statement.setString(6, veiculo.getPlaca());
			statement.setInt(7, veiculo.getQuilometragem());
			statement.setInt(8, veiculo.getCliente().getId());

			statement.execute();
			System.out.println("Veiculo inserido");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
	}

	public Veiculo buscarPorPlaca(String placa) throws SQLException {
		String sql = "SELECT * FROM veiculo WHERE placa_veiculo = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, placa);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int idd = resultSet.getInt("id_veiculo");
				String marca = resultSet.getString("marca_veiculo");
				String tipo = resultSet.getString("tipo_veiculo");
				String modelo = resultSet.getString("modelo_veiculo"); //acesso pelo label
				int anoFabricacao = resultSet.getInt("anoFabricacao_veiculo");
				String placaa = resultSet.getString("placa_veiculo");
				int quilometragem = resultSet.getInt("quilometragem_veiculo");
				
				Veiculo veiculo1 = new Veiculo(idd, marca, tipo, modelo,placaa ,anoFabricacao, quilometragem);
				
				return veiculo1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar veiculo");
		}
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
		return null;
	}

	public void atualizar(Veiculo veiculo, String placa) throws SQLException {
		String sql = "UPDATE veiculo SET marca_veiculo = ?, tipo_veiculo = ?, modelo_veiculo = ?, anoFabricacao_veiculo = ?, placa_veiculo = ?, quilometragem_veiculo = ? WHERE placa_veiculo = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1,veiculo.getMarca());
			ps.setString(2, veiculo.getTipo());
			ps.setString(3, veiculo.getModelo());
			ps.setInt(4, veiculo.getAnoFabricacao());
			ps.setString(5, veiculo.getPlaca());
			ps.setInt(6, veiculo.getQuilometragem());
			ps.setString(7, veiculo.getPlaca());

			ps.execute();
			System.out.println("Executado!");
			
		} catch (SQLException e) {
			if(connection == null) {
				System.err.println("Conexão nula!");
			}else if(connection != null) {
				System.err.println("Erro na transação UPTDATE! " + e.getStackTrace());
			}
		}
		finally {
			connection.close();
			System.out.println("Conexão fechada!");
		}
	}

	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM veiculo WHERE id_veiculo = ?";
		
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
		}finally {
			try {
				connection.close();
				System.out.println("Conexão fechada!");
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
	}	
	
	public ArrayList<Veiculo> listarVeiculosCliente(Cliente cliente) throws SQLException{
		String sql = "SELECT * FROM veiculo WHERE fk_cliente = ?";
		
		try {
			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, cliente.getId());
			statement.execute();
			
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_veiculo");
				String marca = resultSet.getString("marca_veiculo");
				String tipo = resultSet.getString("tipo_veiculo");
				String modelo = resultSet.getString("modelo_veiculo"); //acesso pelo label
				int anoFabricacao = resultSet.getInt("anoFabricacao_veiculo");
				String placa = resultSet.getString("placa_veiculo");
				int quilometragem = resultSet.getInt("quilometragem_veiculo");
				
				Veiculo veiculo = new Veiculo(id, marca, tipo, modelo, placa, anoFabricacao, quilometragem);
				veiculos.add(veiculo);
				System.out.println("Veiculo adicionado");
			}
			return veiculos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar veiculos");
		}
		return null;
	}

}
