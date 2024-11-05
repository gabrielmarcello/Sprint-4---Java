package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	
	private int id;
	private String login;
	private String senha;
	private boolean logado = false;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(int id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	public boolean isLogado() {
		return logado;
	}
	
	public void setLogado() {
		logado = true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", logado=" + logado + "]";
	}
}