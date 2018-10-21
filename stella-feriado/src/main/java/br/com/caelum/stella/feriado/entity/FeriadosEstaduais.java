package br.com.caelum.stella.feriado.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.caelum.stella.feriado.enums.Lugares;
import br.com.caelum.stella.feriado.util.DateUtil;
import br.com.caelum.stella.feriado.util.Ordernador;
import br.com.caelum.stella.feriado.util.XMLUtil;

@XmlRootElement(name="Feriados")
public class FeriadosEstaduais {

	private List<Feriado> feriados = new ArrayList<Feriado>();


	@XmlElement(name = "Feriado", type = Feriado.class)
	public List<Feriado> getFeriados() {
		return feriados;
	}

	@SuppressWarnings("unused")
	private void setFeriados(List<Feriado> feriados) {
		this.feriados = feriados;
	}

	public static Collection<Feriado> de(int ano,Lugares...lugares){
		List<Feriado> feriados = new ArrayList<Feriado>();
		for(Lugares l : lugares){
			feriados.addAll(XMLUtil.xmlToObject(FeriadosEstaduais.class,ano, l).getFeriados());
		}
		Collections.sort(feriados, Ordernador.DATA_CRESCENTE);
		return feriados;
	}
	public static Collection<Feriado> de(Lugares...lugares){
		return  de(DateUtil.getAno(),lugares);
	}
	
	public static boolean ehFeriado(Date data,Lugares...lugares){
		for(Feriado f : de(DateUtil.getAno(data), lugares)){
			if(DateUtil.mesmoDia(data, f.getData())){
				return true;
			}	
		}
		return false;
	}
}