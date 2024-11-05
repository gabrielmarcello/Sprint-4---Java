package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Guincho {

	private int id;
	private int telefone;
	private String tipoGuincho;
	private int capacidadeElevacao;
	private int velocidadeElevacao;
	
	public Guincho(int id, int telefone, String tipoGuincho, int capacidadeElevacao, int velocidadeElevacao) {
		this.id = id;
		this.telefone = telefone;
		this.tipoGuincho = tipoGuincho;
		this.capacidadeElevacao = capacidadeElevacao;
		this.velocidadeElevacao = velocidadeElevacao;
	}
	
	public Guincho(int telefone, String tipoGuincho, int capacidadeElevacao, int velocidadeElevacao) {
		this.telefone = telefone;
		this.tipoGuincho = tipoGuincho;
		this.capacidadeElevacao = capacidadeElevacao;
		this.velocidadeElevacao = velocidadeElevacao;
	}
	
	public int getId() {
		return id;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getTipoGuincho() {
		return tipoGuincho;
	}

	public void setTipoGuincho(String tipoGuincho) {
		this.tipoGuincho = tipoGuincho;
	}

	public int getCapacidadeElevacao() {
		return capacidadeElevacao;
	}

	public void setCapacidadeElevacao(int capacidadeElevacao) {
		this.capacidadeElevacao = capacidadeElevacao;
	}

	public int getVelocidadeElevacao() {
		return velocidadeElevacao;
	}

	public void setVelocidadeElevacao(int velocidadeElevacao) {
		this.velocidadeElevacao = velocidadeElevacao;
	}

	@Override
	public String toString() {
		return "Guincho [telefone=" + telefone + ", tipoGuincho=" + tipoGuincho + ", capacidadeElevacao="
				+ capacidadeElevacao + ", velocidadeElevacao=" + velocidadeElevacao + "]";
	}
	
}
