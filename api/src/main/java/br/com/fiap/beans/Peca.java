package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Peca {
	
	private String tipo;
	private float preco;
	private String status;
	
	public Peca() {
	}
	
	public Peca(String tipo, float preco, String status) {
		this.tipo = tipo;
		this.preco = preco;
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Peca [tipo=" + tipo + ", preco=" + preco + ", status=" + status + "]";
	}

}
