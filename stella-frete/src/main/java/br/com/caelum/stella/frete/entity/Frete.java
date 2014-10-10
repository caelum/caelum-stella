package br.com.caelum.stella.frete.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.stella.frete.adapter.BooleanAdapter;
import br.com.caelum.stella.frete.adapter.DoubleAdapter;
import br.com.caelum.stella.frete.adapter.ServicoAdapter;
import br.com.caelum.stella.frete.enums.Servico;



@XmlRootElement(name="cServico")
public class Frete {

	private Servico codigo;
	private Double valor;
	private int prazoEntrega;
	private Double valorSemAdicionais;
	private Double valorMaoPropria;
	private Double valorAvisoRecebimento;
	private Double valorDeclarado;
	private Boolean entregaDomicilar;
	private Boolean entregaSabado;
	private int erro;
	private String mensagemErro;
	
	@XmlElement(name="Codigo")
	@XmlJavaTypeAdapter(ServicoAdapter.class)
	public Servico getCodigo() {
		return codigo;
	}
	
	@XmlElement(name="Valor")
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getValor() {
		return valor;
	}
	
	@XmlElement(name="PrazoEntrega")
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	
	@XmlElement(name="ValorSemAdicionais")
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getValorSemAdicionais() {
		return valorSemAdicionais;
	}
	
	@XmlElement(name="ValorMaoPropria")
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getValorMaoPropria() {
		return valorMaoPropria;
	}
	
	@XmlElement(name="ValorAvisoRecebimento")
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getValorAvisoRecebimento() {
		return valorAvisoRecebimento;
	}
	
	@XmlElement(name="ValorValorDeclarado")
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getValorDeclarado() {
		return valorDeclarado;
	}
	
	@XmlElement(name="EntregaDomiciliar")
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	public Boolean getEntregaDomicilar() {
		return entregaDomicilar;
	}
	
	@XmlElement(name="EntregaSabado")
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	public Boolean getEntregaSabado() {
		return entregaSabado;
	}
	
	@XmlElement(name="Erro")
	public int getErro() {
		return erro;
	}
	
	@XmlElement(name="MsgErro")
	public String getMensagemErro() {
		return mensagemErro;
	}
		
	@SuppressWarnings("unused")
	private void setCodigo(Servico codigo) {
		this.codigo = codigo;
	}
	
	@SuppressWarnings("unused")
	private void setValor(Double valor) {
		this.valor = valor;
	}
	
	@SuppressWarnings("unused")
	private void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	
	@SuppressWarnings("unused")
	private void setValorSemAdicionais(Double valorSemAdicionais) {
		this.valorSemAdicionais = valorSemAdicionais;
	}

	@SuppressWarnings("unused")
	private void setValorMaoPropria(Double valorMaoPropria) {
		this.valorMaoPropria = valorMaoPropria;
	}

	@SuppressWarnings("unused")
	private void setValorAvisoRecebimento(Double valorAvisoRecebimento) {
		this.valorAvisoRecebimento = valorAvisoRecebimento;
	}

	@SuppressWarnings("unused")
	private void setValorDeclarado(Double valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}

	@SuppressWarnings("unused")
	private void setEntregaDomicilar(Boolean entregaDomicilar) {
		this.entregaDomicilar = entregaDomicilar;
	}

	@SuppressWarnings("unused")
	private void setEntregaSabado(Boolean entregaSabado) {
		this.entregaSabado = entregaSabado;
	}

	@SuppressWarnings("unused")
	private void setErro(int erro) {
		this.erro = erro;
	}
	
	@SuppressWarnings("unused")
	private void setMensagemErro(String mensagemErro){
		this.mensagemErro = mensagemErro;
	}
}
