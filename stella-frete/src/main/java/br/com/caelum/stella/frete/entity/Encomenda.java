package br.com.caelum.stella.frete.entity;

import br.com.caelum.stella.frete.enums.Formato;
import br.com.caelum.stella.frete.util.Strings;
import static br.com.caelum.stella.frete.util.ResourceUtil.getValue;
import static br.com.caelum.stella.frete.util.ResourceUtil.getValueAsDouble;
public class Encomenda {
	
	private String codigoEmpresa;  
	private String senha;   
	private Double peso;  
	private Formato formato;  
	private String comprimento;  
	private String altura;  
	private String largura; 
	private String diametro;  
	private String maoPropria;  
	private Double valorDeclarado;  
	private String avisoRecebimento;  
	private String StrRetorno;
	private String cepDestino;
	private String cepOrigem;
	
	public Encomenda(){
		codigoEmpresa = getValue("br.com.caelum.stella.frete.encomenda.codempresa"); 
		senha = getValue("br.com.caelum.stella.frete.encomenda.senha");
		peso = getValueAsDouble("br.com.caelum.stella.frete.encomenda.peso");
		formato = Formato.getFormato(getValue("br.com.caelum.stella.frete.encomenda.formato"));
		comprimento = getValue("br.com.caelum.stella.frete.encomenda.comprimento");
		altura = getValue("br.com.caelum.stella.frete.encomenda.altura");
		largura =  getValue("br.com.caelum.stella.frete.encomenda.largura");
		diametro = getValue("br.com.caelum.stella.frete.encomenda.diametro");
		maoPropria = getValue("br.com.caelum.stella.frete.encomenda.maopropria"); 
		valorDeclarado = getValueAsDouble("br.com.caelum.stella.frete.encomenda.valordeclarado");
		avisoRecebimento = getValue("br.com.caelum.stella.frete.encomenda.avisorecebimento");
		cepOrigem = Strings.onlyNumbers(getValue("br.com.caelum.stella.frete.encomenda.ceporigem")); 
		cepDestino= "";
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public String getSenha() {
		return senha;
	}

	public String getPeso() {
		return peso.toString();
	}

	public Formato getFormato() {
		return formato;
	}

	public String getComprimento() {
		return comprimento;
	}

	public String getAltura() {
		return altura;
	}

	public String getLargura() {
		return largura;
	}

	public String getDiametro() {
		return diametro;
	}

	public String getMaoPropria() {
		return maoPropria;
	}
	
	public String getCepOrigem(){
		return cepOrigem;
	}
	
	public String getCepDestino(){
		return cepDestino;
	}
	
	public String getValorDeclarado() {
		return Strings.doubleToString(valorDeclarado);
	}

	public String getAvisoRecebimento() {
		return avisoRecebimento;
	}

	public String getStrRetorno() {
		return StrRetorno;
	}
	
	public Encomenda paraAEmpresa(String codigoEmpresa){
		this.codigoEmpresa = codigoEmpresa;
		return this;
	}
	public Encomenda comSenha(String senha){
		this.senha = senha;
		return this;
	}
	
	public Encomenda comPeso(Double peso){
		this.peso = peso;
		return this;
	}
	
	public Encomenda noFormato(Formato formato){
		this.formato = formato;
		return this;
	}
	
	public Encomenda comComprimento(String comprimento){
		this.comprimento = comprimento;
		return this;
	}
	
	public Encomenda comAltura(String altura){
		this.altura = altura;
		return this;
	}
	
	public Encomenda comLargura(String largura){
		this.largura = largura;
		return this;
	}
	
	public Encomenda comDiametro(String diametro){
		this.diametro = diametro;
		return this;
	}
	
	public Encomenda comMaoPropria(){
		this.maoPropria = "s" ;
		return this;
	}
	
	public Encomenda semMaoPropria(){
		this.maoPropria = "n" ;
		return this;
	}
	
	public Encomenda comValorDeclarado(Double valor){
		this.valorDeclarado = valor;
		return this;
	}
	
	public Encomenda comAvisoDeRecebimento(){
		this.avisoRecebimento = "s";
		return this;
	}
	
	public Encomenda semAvisoDeRecebimento(){
		this.avisoRecebimento = "n";
		return this;
	}
	
	public Encomenda doCep(String cepOrigem){
		this.cepOrigem = Strings.onlyNumbers(cepOrigem);
		return this;
	}
	public Encomenda paraOCep(String cepDestino){
		this.cepDestino = Strings.onlyNumbers(cepDestino);
		return this;
	}
}