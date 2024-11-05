package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.interfaces.ICryptographyService;
import br.com.fiap.interfaces.IUsuarioDAO;
import br.com.fiap.services.CryptographyService;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

public class UsuarioDAOImpl implements IUsuarioDAO{

	private Connection connection;
	private ICryptographyService _cryptographyService = new CryptographyService();
	
	public UsuarioDAOImpl() throws ClassNotFoundException, SQLException {
		this.connection = new ConexaoFactory().conexao();
	}
	
	public void salvarUsuario(Usuario usuario) throws SQLException {
		try {
			String sql = "INSERT INTO usuario (login_usuario, senha_usuario) VALUES(?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getLogin());
			statement.setString(2, usuario.getSenha());
			statement.execute();
			System.out.println("Usuario inserido");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario exibirUsuarioPorId(int id) throws SQLException{
		
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int identificador = resultSet.getInt("id_usuario"); //acesso pelo label
				String loginn = resultSet.getString("login_usuario");
				String senha = resultSet.getString("senha_usuario"); 
				
				Usuario usuario = new Usuario(identificador, loginn, senha);
				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar usuario");
		}
		return null;
	}
	
	public Usuario buscarUsuario(String login, String senha) {
		
		String sql = "SELECT * FROM usuario WHERE login_usuario = ? and senha_usuario = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			String hashedPassword = _cryptographyService.GenerateMD5Hash(senha);
			
			statement.setString(1, login);
			statement.setString(2, hashedPassword);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int ID = resultSet.getInt("id_usuario");
				String Login = resultSet.getString("login_usuario");
				String Senha = resultSet.getString("senha_usuario"); 
				
				Usuario usuario = new Usuario(ID, Login, Senha);
				
				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao buscar usuario");
		}
		return null;
	}
}
