package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.interfaces.IClienteDAO;
import br.com.fiap.beans.Cliente;
import br.com.fiap.conexoes.ConexaoFactory;

public class ClienteDAOImpl implements IClienteDAO{
	
private Connection connection;
	
	public ClienteDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}

	public void inserir(Cliente cliente) throws SQLException {
		try {
			String sql = "INSERT INTO cliente (nome_cliente, telefone_cliente, cpf_cliente, endereco_cliente, email_cliente, cliente_fk_usuario) VALUES(?, ?, ? ,? ,?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setInt(2, cliente.getTelefone());
			statement.setInt(3, cliente.getCpf());
			statement.setString(4, cliente.getEndereco());
			statement.setString(5, cliente.getEmail());
			statement.setInt(6, cliente.getUsuario().getId());
			statement.execute();
			System.out.println("Cliente inserido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> listar() throws SQLException {
		try {
			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			String sql = "SELECT * FROM cliente";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				int id = resultSet.getInt("id_cliente");
				String nome = resultSet.getString("nome_cliente");
				int telefone = resultSet.getInt("telefone_cliente");
				int cpf = resultSet.getInt("cpf_cliente"); //acesso pelo label
				String endereco = resultSet.getString("endereco_cliente");
				String email = resultSet.getString("email_cliente");
				
				//cria um objeto de Cliente
				Cliente cliente = new Cliente(id, nome, telefone, cpf, endereco, email);
				clientes.add(cliente);
			}
			return clientes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar clientes");
		}
		return null;
	}

	public Cliente buscarPorCpf(int cpf) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE cpf_cliente = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, cpf);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Executado");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id_cliente");
				String nome = resultSet.getString("nome_cliente");
				int telefone = resultSet.getInt("telefone_cliente");
				int CPF = resultSet.getInt("cpf_cliente"); //acesso pelo label
				String endereco = resultSet.getString("endereco_cliente");
				String email = resultSet.getString("email_cliente");
				
				//cria um objeto de Cliente
				Cliente cliente = new Cliente(id, nome, telefone, CPF, endereco, email);
				
				return cliente;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar cliente");
		}
		return null;
	}

	public void atualizar(Cliente cliente, int id) throws SQLException { 
		String sql = "UPDATE cliente SET nome_cliente = ?, telefone_cliente = ?, cpf_cliente = ?, endereco_cliente = ?, email_cliente = ? WHERE id_cliente = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getTelefone());
			ps.setInt(3, cliente.getCpf());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getEmail());
			ps.setInt(6, id);
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

	public void deletar(int cpf) throws SQLException {
		String sql = "DELETE FROM cliente WHERE cpf_cliente = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, cpf);
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