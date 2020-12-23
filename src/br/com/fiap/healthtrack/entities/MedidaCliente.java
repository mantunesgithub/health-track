package br.com.fiap.healthtrack.entities;

import java.util.Calendar;

/**
 * O objetivo desta classe cadastrar as medidas gerais do cliente
 * 
 * @author antun
 * @version 1.0
 */

public class MedidaCliente {
	private Integer idMedidaCliente;
	private Calendar   dtMedicao;
	private Double vlPeso;
	private Double vlAltura;
	private String vlPressao;
	private Double qtCalConsDia;
	private Double vlCoefCalculo;
	private Double vlfreqCardiaca;
	private Double vlMedidaPescoco;
	private Double vlMedidaAnteBraco;
	private Double vlMedidaPeito;
	private Double vlMedidaCintura;
	private Double vlMedidaQuadris;
	private Double vlMedidaCoxas;
	private Double vlMedidaPanturrilha;
	private Double idFatorAtividade;
	private Double vlGastoEnergReal;
	private Double vlIMCCalculado;
	private String msgIMCCalculado;
	private Double vlTMBCalculado;
	private String msgTMBCalculado;
	private String dsObservacao;
	private Long cdCPFcliente;
	
	
	public MedidaCliente() {
		super();
	}
	public MedidaCliente(Integer idMedidaCliente, Calendar dtMedicao, Double vlPeso, Double vlAltura, String vlPressao,
			Double qtCalConsDia, Double vlCoefCalculo, Double vlfreqCardiaca, Double vlMedidaPescoco,
			Double vlMedidaAnteBraco, Double vlMedidaPeito, Double vlMedidaCintura, Double vlMedidaQuadris,
			Double vlMedidaCoxas, Double vlMedidaPanturrilha, Double idFatorAtividade, Double vlGastoEnergReal,
			Double vlIMCCalculado, Double vlTMBCalculado, String dsObservacao, Long cdCPFcliente) {
		super();
		this.idMedidaCliente = idMedidaCliente;
		this.dtMedicao = dtMedicao;
		this.vlPeso = vlPeso;
		this.vlAltura = vlAltura;
		this.vlPressao = vlPressao;
		this.qtCalConsDia = qtCalConsDia;
		this.vlCoefCalculo = vlCoefCalculo;
		this.vlfreqCardiaca = vlfreqCardiaca;
		this.vlMedidaPescoco = vlMedidaPescoco;
		this.vlMedidaAnteBraco = vlMedidaAnteBraco;
		this.vlMedidaPeito = vlMedidaPeito;
		this.vlMedidaCintura = vlMedidaCintura;
		this.vlMedidaQuadris = vlMedidaQuadris;
		this.vlMedidaCoxas = vlMedidaCoxas;
		this.vlMedidaPanturrilha = vlMedidaPanturrilha;
		this.idFatorAtividade = idFatorAtividade;
		this.vlGastoEnergReal = vlGastoEnergReal;
		this.vlIMCCalculado = vlIMCCalculado;
		this.vlTMBCalculado = vlTMBCalculado;
		this.dsObservacao = dsObservacao;
		this.cdCPFcliente = cdCPFcliente;
	}
	
	public Integer getIdMedidaCliente() {
		return idMedidaCliente;
	}
	public void setIdMedidaCliente(Integer idMedidaCliente) {
		this.idMedidaCliente = idMedidaCliente;
	}
	public Calendar getDtMedicao() {
		return dtMedicao;
	}
	public void setDtMedicao(Calendar dtMedicao) {
		this.dtMedicao = dtMedicao;
	}
	public Double getVlPeso() {
		return vlPeso;
	}
	public void setVlPeso(Double vlPeso) {
		this.vlPeso = vlPeso;
	}
	public Double getVlAltura() {
		return vlAltura;
	}
	public void setVlAltura(Double vlAltura) {
		this.vlAltura = vlAltura;
	}
	public String getVlPressao() {
		return vlPressao;
	}
	public void setVlPressao(String vlPressao) {
		this.vlPressao = vlPressao;
	}
	public Double getQtCalConsDia() {
		return qtCalConsDia;
	}
	public void setQtCalConsDia(Double qtCalConsDia) {
		this.qtCalConsDia = qtCalConsDia;
	}
	public Double getVlCoefCalculo() {
		return vlCoefCalculo;
	}
	public void setVlCoefCalculo(Double vlCoefCalculo) {
		this.vlCoefCalculo = vlCoefCalculo;
	}
	public Double getVlfreqCardiaca() {
		return vlfreqCardiaca;
	}
	public void setVlfreqCardiaca(Double vlfreqCardiaca) {
		this.vlfreqCardiaca = vlfreqCardiaca;
	}
	public Double getVlMedidaPescoco() {
		return vlMedidaPescoco;
	}
	public void setVlMedidaPescoco(Double vlMedidaPescoco) {
		this.vlMedidaPescoco = vlMedidaPescoco;
	}
	public Double getVlMedidaAnteBraco() {
		return vlMedidaAnteBraco;
	}
	public void setVlMedidaAnteBraco(Double vlMedidaAnteBraco) {
		this.vlMedidaAnteBraco = vlMedidaAnteBraco;
	}
	public Double getVlMedidaPeito() {
		return vlMedidaPeito;
	}
	public void setVlMedidaPeito(Double vlMedidaPeito) {
		this.vlMedidaPeito = vlMedidaPeito;
	}
	public Double getVlMedidaCintura() {
		return vlMedidaCintura;
	}

	public void setVlMedidaCintura(Double vlMedidaCintura) {
		this.vlMedidaCintura = vlMedidaCintura;
	}
	public Double getVlMedidaQuadris() {
		return vlMedidaQuadris;
	}
	public void setVlIMCCalculado(Double vlIMCCalculado) {
		this.vlIMCCalculado = vlIMCCalculado;
	}
	public void setVlTMBCalculado(Double vlTMBCalculado) {
		this.vlTMBCalculado = vlTMBCalculado;
	}
	public void setVlMedidaQuadris(Double vlMedidaQuadris) {
		this.vlMedidaQuadris = vlMedidaQuadris;
	}
	public Double getVlMedidaCoxas() {
		return vlMedidaCoxas;
	}
	public void setVlMedidaCoxas(Double vlMedidaCoxas) {
		this.vlMedidaCoxas = vlMedidaCoxas;
	}
	public Double getVlMedidaPanturrilha() {
		return vlMedidaPanturrilha;
	}
	public void setVlMedidaPanturrilha(Double vlMedidaPanturrilha) {
		this.vlMedidaPanturrilha = vlMedidaPanturrilha;
	}
	public Double getIdFatorAtividade() {
		return idFatorAtividade;
	}
	public void setIdFatorAtividade(Double idFatorAtividade) {
		this.idFatorAtividade = idFatorAtividade;
	}
	public Double getVlGastoEnergReal() {
		return vlGastoEnergReal;
	}
	public void setVlGastoEnergReal(Double vlGastoEnergReal) {
		this.vlGastoEnergReal = vlGastoEnergReal;
	}
	public Double getVlIMCCalculado() {
		return (getVlPeso() / (getVlAltura() * getVlAltura()));  
	}
	
	public Double getVlTMBCalculado() {
		return vlTMBCalculado;
	}

	public String getDsObservacao() {
		return dsObservacao;
	}
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}
	public Long getCdCPFcliente() {
		return cdCPFcliente;
	}
	public void setCdCPFcliente(Long cdCPFcliente) {
		this.cdCPFcliente = cdCPFcliente;
	}
	public String getMsgIMCCalculado() {
		
		getVlIMCCalculado();
		
		if  (this.vlIMCCalculado < 18.5 ) {
			this.msgIMCCalculado = "IMC BAIXO";
		} if (vlIMCCalculado >= 18.5 && vlIMCCalculado <= 24.9) {
			this.msgIMCCalculado = "IMC ADEQUADO";
		} if (vlIMCCalculado >= 25 && vlIMCCalculado <= 29.9) {
			this.msgIMCCalculado = "IMC COM SOBREPESO";
		} if (vlIMCCalculado >= 30) {
			this.msgIMCCalculado = "IMC COM OBESIDADE";
		}
		
		return msgIMCCalculado;
	}
	public void setMsgIMCCalculado(String msgIMCCalculado) {
		this.msgIMCCalculado = msgIMCCalculado;
	}
	public String getMsgTMBCalculado() {
		
		return msgTMBCalculado;
	}
	public void setMsgTMBCalculado(String msgTMBCalculado) {
		this.msgTMBCalculado = msgTMBCalculado;
	}
}


