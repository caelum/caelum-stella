package br.com.caelum.stella.feriado.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.stella.feriado.adapter.TipoAdapter;
import br.com.caelum.stella.feriado.enums.Tipo;
import br.com.caelum.stella.feriado.util.DateUtil;
import br.com.caelum.stella.feriado.util.ResourceUtil;

@XmlRootElement(name="Feriado")
public class Feriado {

	private String key;
	private Date data;
	private Tipo tipo;
	private int dia;
	private int mes;
	private String local;

	public Feriado(String key, Date data, Tipo tipo,String local) {
		this.key = key;
		this.data = data;
		this.tipo = tipo;
		this.dia = DateUtil.getDiaDoMes(data);
		this.mes = DateUtil.getMes(data);
		this.local = local;
	}	

	@SuppressWarnings("unused")
	private Feriado(){}

	public Feriado(String key, int dia, int ano, Tipo tipo,String local) {
		this.key = key;
		this.tipo = tipo;
		this.dia = dia;
		this.mes =ano;
		this.local = local;
	}

	@XmlAttribute(name="key")
	public String getKey() {
		return key;
	}

	public Date getData() {
		return data;
	}
	
	public String getNome() {
		return ResourceUtil.getValue(key);
	}
		
	@XmlAttribute(name="tipo")
	@XmlJavaTypeAdapter(TipoAdapter.class)
	public Tipo getTipo() {
		return tipo;
	}

	@XmlAttribute(name="dia")
	public int getDia() {
		return dia;
	}

	@XmlAttribute(name="mes")
	public int getMes() {
		return mes;
	}
	
	@XmlAttribute(name="local")
	public String getLocal() {
		return local;
	}

	@SuppressWarnings("unused")
	private void setKey(String key) {
		this.key = key;
	}

	@SuppressWarnings("unused")
	private void setData(Date data) {
		this.data = data;
	}

	@SuppressWarnings("unused")
	private void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@SuppressWarnings("unused")
	private void setDia(int dia) {
		this.dia = dia;
	}

	@SuppressWarnings("unused")
	private void setMes(int mes) {
		this.mes = mes;
	}
	
	@SuppressWarnings("unused")
	private void setLocal(String local) {
		this.local = local;
	}

	public void ajustarData(Date data){
		this.data = DateUtil.zerarHora(data).getTime();
	}
	
	@Override
	public String toString() {
		String oc = new Date().before(data) ? " ocorrerá no dia " : " ocorreu no dia ";
		return getNome() + oc + DateUtil.formatterExtenso.format(data) + " em " + getLocal();
	}

	
}
