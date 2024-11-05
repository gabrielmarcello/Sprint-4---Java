package br.com.fiap.beans;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orcamento {
	
	private int id;
	private Date data;
	private List<Peca> pecas;
	private float valorTotal;
	private Oficina oficina;
	
	public Orcamento(Date data, float valorTotal, Oficina oficina) {
		this.data = data;
		this.valorTotal = valorTotal;
		this.oficina = oficina;
	}

	public Orcamento(Date data, List<Peca> pecas, float valorTotal) {
		this.data = data;
		this.pecas = pecas;
		this.valorTotal = valorTotal;
	}
	
	public Orcamento(int id, java.util.Date data2, float valorTotal, Oficina oficina) {
		this.id = id;
		this.data = (Date) data2;
		this.valorTotal = valorTotal;
		this.oficina = oficina;
	}
	
	public Orcamento(int id, Date data, List<Peca> pecas, float valorTotal, Oficina oficina) {
		this.id = id;
		this.data = data;
		this.pecas = pecas;
		this.valorTotal = valorTotal;
		this.oficina = oficina;
	}
	
	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

}