package br.com.fiap.beans;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Diagnostico {

	private int id;
	private String solucao;
	private String problema;
	private Date data;
	private Veiculo veiculo;
	private Orcamento orcamento;
	
	public Diagnostico(int id, String solucao, String problema, Date data, Veiculo veiculo, Orcamento orcamento) {
		this.id = id;
		this.solucao = solucao;
		this.problema = problema;
		this.data = data;
		this.veiculo = veiculo;
		this.orcamento = orcamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	@Override
	public String toString() {
		return "Diagnostico [id=" + id + ", solucao=" + solucao + ", problema=" + problema + ", data=" + data
				+ ", veiculo=" + veiculo + ", orcamento=" + orcamento + "]";
	}
}
