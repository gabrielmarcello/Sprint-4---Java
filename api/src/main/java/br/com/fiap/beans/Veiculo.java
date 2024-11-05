package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Veiculo {
	
	private int id;
	private String marca;
	private String tipo;
	private String modelo;
	private int anoFabricacao;
	private String placa;
	private int quilometragem;
	private Cliente cliente;
	
	public Veiculo(String marca, String tipo, String modelo, int anoFabricacao, String placa, int quilometragem) {
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}
	
	public Veiculo(int id, String marca, String tipo, String modelo,String placa, int anoFabricacao, int quilometragem) {
		this.id = id;
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}
	
	public Veiculo(int id, String marca, String tipo, String modelo, int anoFabricacao, String placa, int quilometragem, Cliente cliente) {
		this.id = id;
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.cliente = cliente;
	}
	
	public int getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", tipo=" + tipo + ", modelo=" + modelo + ", anoFabricacao="
				+ anoFabricacao + ", placa=" + placa + ", quilometragem=" + quilometragem + "]";
	}
}
