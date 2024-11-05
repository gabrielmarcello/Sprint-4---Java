package br.com.fiap.interfaces;

import java.sql.SQLException;

import br.com.fiap.beans.Usuario;

public interface IUsuarioDAO {
	
	public void salvarUsuario(Usuario usuario) throws SQLException;
	public Usuario exibirUsuarioPorId(int id) throws SQLException;
	public Usuario buscarUsuario(String login, String senha) throws SQLException;

}
