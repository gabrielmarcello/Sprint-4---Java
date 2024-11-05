package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oficina {

	private int id;
	private String endereco;
	private int telefone;
	private int cep;
	private Diagnostico diagnostico;
	
	public Oficina(int id, String endereco, int telefone, int cep) {
		this.id = id;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Oficina(String endereco, int telefone, int cep) {
		this.endereco = endereco;
		this.telefone = telefone;
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "Oficina [endereco=" + endereco + ", telefone=" + telefone + ", cep=" + cep + "]";
	}
	
}