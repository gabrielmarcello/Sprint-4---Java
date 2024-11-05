package br.com.fiap.interfaces;

import java.sql.SQLException;

import br.com.fiap.beans.Usuario;

public interface IAuthenticationService {

	public Usuario Login(int id, String login, String password) throws SQLException;
	
}
