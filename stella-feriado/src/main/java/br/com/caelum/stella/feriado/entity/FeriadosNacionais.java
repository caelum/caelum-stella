package br.com.caelum.stella.feriado.entity;

import java.util.ArrayList;
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
public class FeriadosNacionais  {

	private List<Feriado> feriados = new ArrayList<Feriado>();


	@XmlElement(name = "Feriado", type = Feriado.class)
	public List<Feriado> getFeriados() {
		return feriados;
	}

	@SuppressWarnings("unused")
	private void setFeriados(List<Feriado> feriados) {
		this.feriados = feriados;
	}
	
	
	public static List<Feriado> doAno(int ano){
			List<Feriado> feriados = XMLUtil.xmlToObject(FeriadosNacionais.class,ano,Lugares.Brasil).getFeriados();
			feriados.addAll(FeriadosMoveis.doAno(ano));
			Collections.sort(feriados, Ordernador.DATA_CRESCENTE);
			return feriados;
	}
	
	public static List<Feriado> doAno(){
		 return doAno(DateUtil.getAno(DateUtil.hoje().getTime()));
	}

	public static boolean ehFeriado(Date data){
		int ano = DateUtil.getAno(data);
		for(Feriado f : doAno(ano)){
			if(DateUtil.mesmoDia(data, f.getData())){
				return true;
			}	
		}
		return false;
	}
}