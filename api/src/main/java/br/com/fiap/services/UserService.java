package br.com.fiap.services;

import java.sql.SQLException;

import br.com.fiap.interfaces.ICryptographyService;
import br.com.fiap.interfaces.IUserRepository;
import br.com.fiap.beans.Usuario;

public class UserService {
	
	private IUserRepository _userRepository;
	private ICryptographyService _cryptographyService;
	
	public UserService(IUserRepository _userRepository, ICryptographyService _cryptographyService) {
		this._userRepository = _userRepository;
		this._cryptographyService = _cryptographyService;
	}
	
	public boolean RegistrarUsuario(Usuario usuario) throws SQLException {
		
		String hashedPassword = _cryptographyService.GenerateMD5Hash(usuario.getSenha());
		Usuario user = new Usuario(usuario.getLogin(), hashedPassword);
		
		_userRepository.salvarUsuario(user);
		return true;
	}

}
