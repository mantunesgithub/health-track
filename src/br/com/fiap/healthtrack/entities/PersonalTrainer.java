package br.com.fiap.healthtrack.entities;

import java.util.Date;

import br.com.fiap.healthtrack.entities.enums.StatusPersonal;

/**
 * Classe que abstrai um Personal trainer - responsavel em criar os treinos
 * 
 * @author antun
 *
 */
public class PersonalTrainer {
	private Long cpfPersonal;
	private String nome;
	private String cref;
	private Long rg;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private String email;
	private Integer cepPrefixo;
	private Integer cepSufixo;
	private Integer statusPersonal;
	private Integer ddiCelular;
	private Integer dddCelular;
	private Integer numeroCelular;
	private Date dataInclusao;

	
public PersonalTrainer() {
	}

public PersonalTrainer(Long cpfPersonal, String nome, String cref, Integer dddCelular, Integer numeroCelular) {
		this.cpfPersonal = cpfPersonal;
		this.nome = nome;
		this.cref = cref;
		this.dddCelular = dddCelular;
		this.numeroCelular = numeroCelular;
	}

public PersonalTrainer(Long cpfPersonal, String nome, String cref, Long rg, String endereco, Integer numero,
		String complemento, String bairro, String cidade, String uf, String pais, String email, Integer cepPrefixo,
		Integer cepSufixo, Integer statusPersonal, Integer ddiCelular, Integer dddCelular, Integer numeroCelular,
		Date dataInclusao) {
	this.cpfPersonal = cpfPersonal;
	this.nome = nome;
	this.cref = cref;
	this.rg = rg;
	this.endereco = endereco;
	this.numero = numero;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cidade = cidade;
	this.uf = uf;
	this.pais = pais;
	this.email = email;
	this.cepPrefixo = cepPrefixo;
	this.cepSufixo = cepSufixo;
	this.statusPersonal = statusPersonal;
	this.ddiCelular = ddiCelular;
	this.dddCelular = dddCelular;
	this.numeroCelular = numeroCelular;
	this.dataInclusao = dataInclusao;
}

	/**
	 * Metodos Getters e Seters
	 * 
	 */
	public Long getCpfPersonal() {
		return cpfPersonal;
	}

	public void setCpfPersonal(Long cpfPersonal) {
		this.cpfPersonal = cpfPersonal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCepPrefixo() {
		return cepPrefixo;
	}

	public void setCepPrefixo(Integer cepPrefixo) {
		this.cepPrefixo = cepPrefixo;
	}

	public Integer getCepSufixo() {
		return cepSufixo;
	}

	public void setCepSufixo(Integer cepSufixo) {
		this.cepSufixo = cepSufixo;
	}
		
	public Integer getStatusPersonal() {
		return Integer.valueOf(statusPersonal);
	}

	public void setStatusPersonalTrainer(StatusPersonal statusPersonal) {
		this.statusPersonal = statusPersonal.getCode();
	}

	public Integer getDdiCelular() {
		return ddiCelular;
	}

	public void setDdiCelular(Integer ddiCelular) {
		this.ddiCelular = ddiCelular;
	}

	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}

	public Integer getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	
	@Override
	public String toString() {
		return "Personal [cpfPersonal=" + cpfPersonal + ", nome=" + nome + ", cref=" + cref + ", rg=" + rg + ", endereco="
				+ endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade="
				+ cidade + ", uf=" + uf + ", pais=" + pais + ", email=" + email + ", cepPrefixo=" + cepPrefixo
				+ ", cepSufixo=" + cepSufixo + ", statusPersonal=" + statusPersonal + ", ddiCelular="
				+ ddiCelular + ", dddCelular=" + dddCelular + ", numeroCelular=" + numeroCelular + ", dataInclusao="
				+ dataInclusao + "]";
	}
}
