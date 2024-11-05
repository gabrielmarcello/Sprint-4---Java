package br.com.fiap.services;

import java.sql.SQLException;

import br.com.fiap.interfaces.IAuthenticationService;
import br.com.fiap.interfaces.ICryptographyService;
import br.com.fiap.interfaces.IUserRepository;
import br.com.fiap.beans.Usuario;

public class AuthenticationService implements IAuthenticationService{
	
	private IUserRepository _userRepository;
	private ICryptographyService _cryptographyService;
	
	public AuthenticationService(IUserRepository _userRepository, ICryptographyService _cryptographyService) {
		this._userRepository = _userRepository;
		this._cryptographyService = _cryptographyService;
	}
	
	public Usuario Login(int id, String login, String password) throws SQLException{
		Usuario usuario = _userRepository.exibirUsuarioPorId(id);
		if(usuario == null) {
			System.out.println("Usuário não encontrado");
			return null;
		}
		
		String hashedPassword = _cryptographyService.GenerateMD5Hash(password);
		if(usuario.getLogin().equals(login) &&  usuario.getSenha().equals(hashedPassword)) {
			usuario.setLogado();
			return usuario;
		}
		else {
			return null;
		}
	}

}
