package br.com.fiap.bo;

import java.sql.SQLException;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAOImpl;

public class UsuarioBO {

	public UsuarioBO(){
		
	}
	
	UsuarioDAOImpl usuarioDAO = null;
	
	public void inserirBO(Usuario usuario) throws ClassNotFoundException, SQLException {
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		
		//Aplicação de regras de negócio... (se houver)
		
		usuarioDAO.salvarUsuario(usuario);
	}
	
	public Usuario buscarBO(String login, String senha) throws ClassNotFoundException, SQLException {
		
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		
		//Aplicação de regra de negócio... (se houver)
		
		return usuarioDAO.buscarUsuario(login, senha);
		
	}
	
	public Usuario exibirPorIdBO(int id) throws ClassNotFoundException, SQLException {
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		
		return usuarioDAO.exibirUsuarioPorId(id);
	}

}
