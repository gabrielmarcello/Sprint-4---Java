package br.com.fiap.interfaces;

import java.sql.SQLException;

import br.com.fiap.beans.Usuario;

public interface IUserRepository {

	public Usuario exibirUsuarioPorId(int id) throws SQLException;
	public void salvarUsuario(Usuario usuario) throws SQLException;
	
}
