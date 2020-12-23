package br.com.fiap.healthtrack.entities;

import java.util.Calendar;

import br.com.fiap.healthtrack.entities.enums.StatusCliente;
import br.com.fiap.healthtrack.util.CriptografiaUtils;

/**
 * O objetivo desta classe é abstrair os dados cadastrais do cliente
 * 
 * @author antun
 * @version 1.0
 */
public class Cliente {
	private Long cdCPFCliente;
	private String nome;
	private String email;
	private Calendar dataNascimento;
	private Integer ddiCelular;
	private Integer dddCelular;
	private Integer numeroCelular;
	private String senhaAtual;
	private Integer statusCliente;
	//----
	private Integer rg;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private Integer cepPrefixo;
	private Integer cepSufixo;
	private String profissao;
	private String senhaAnterior;
	private Integer tentativasErro;
	private Calendar dataAlteracao;
	private Calendar dataInclusao;



	public Cliente(Long cdCPFCliente, String nome, String email, Calendar dataNascimento,
			Integer dddCelular,Integer numeroCelular, Integer statusCliente) {
		this.cdCPFCliente = cdCPFCliente;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dddCelular = dddCelular;
		this.numeroCelular = numeroCelular;
		this.statusCliente = statusCliente;
	}

	public Cliente(Long cdCPFCliente, String nome, String email, Calendar dataNascimento, Integer ddiCelular,
			Integer dddCelular, Integer numeroCelular, String senhaAtual, Integer statusCliente, Integer rg,
			String endereco, Integer numero, String complemento, String bairro, String cidade, String uf, String pais,
			Integer cepPrefixo, Integer cepSufixo, String profissao, String senhaAnterior, Integer tentativasErro,
			Calendar dataAlteracao, Calendar dataInclusao) {
		super();
		this.cdCPFCliente = cdCPFCliente;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.ddiCelular = ddiCelular;
		this.dddCelular = dddCelular;
		this.numeroCelular = numeroCelular;
		this.senhaAtual = senhaAtual;
		this.statusCliente = statusCliente;
		this.rg = rg;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.cepPrefixo = cepPrefixo;
		this.cepSufixo = cepSufixo;
		this.profissao = profissao;
		this.senhaAnterior = senhaAnterior;
		this.tentativasErro = tentativasErro;
		this.dataAlteracao = dataAlteracao;
		this.dataInclusao = dataInclusao;
	}

	public Cliente () {
	}

	public Cliente(String email, String senhaAtual) {
		this.email = email;
		setSenhaAtual(senhaAtual);
	}

	/**
	 * Metodos Getters e Seters
	 * 
	 */
	public Long getCdCPFCliente() {
		return cdCPFCliente;
	}

	public void setCdCPFCliente(Long cdCPFCliente) {
		this.cdCPFCliente = cdCPFCliente;
	}

	public Integer getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(StatusCliente statusCliente) {
		this.statusCliente = statusCliente.getCode();
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		try {
			this.senhaAtual = CriptografiaUtils.criptografar(senhaAtual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSenhaAnterior() {
		return senhaAnterior;
	}

	public void setSenhaAnterior(String senhaAnterior) {
		this.senhaAnterior = senhaAnterior;
	}

	public Integer getTentativasErro() {
		return tentativasErro;
	}

	public void setTentativasErro(Integer tentativasErro) {
		this.tentativasErro = tentativasErro;
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

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}


	@Override
	public String toString() {
		return "Cliente [cdCPFCliente=" + cdCPFCliente + ", nome=" + nome + ", rg=" + rg + ", dataNascimento="
				+ dataNascimento + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", pais=" + pais + ", cepPrefixo="
				+ cepPrefixo + ", cepSufixo=" + cepSufixo + ", statusCliente=" + statusCliente + ", email=" + email
				+ ", profissao=" + profissao + ", senhaAtual=" + senhaAtual + ", senhaAnterior=" + senhaAnterior
				+ ", tentativasErro=" + tentativasErro + ", ddiCelular=" + ddiCelular + ", dddCelular=" + dddCelular
				+ ", numeroCelular=" + numeroCelular + ", dataAlteracao=" + dataAlteracao + ", dataInclusao="
				+ dataInclusao + "]";
	}


	
}
