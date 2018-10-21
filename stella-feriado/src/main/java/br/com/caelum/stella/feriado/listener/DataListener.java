package br.com.caelum.stella.feriado.listener;

import java.text.ParseException;

import javax.xml.bind.Unmarshaller.Listener;

import br.com.caelum.stella.feriado.entity.Feriado;
import br.com.caelum.stella.feriado.util.DateUtil;

public class DataListener extends Listener {

	
	private int ano;
	
	public DataListener(int ano) {
			this.ano = ano;
	}

	@Override
	public void afterUnmarshal(Object target, Object parent) {
		super.afterUnmarshal(target, parent);
		if(target instanceof Feriado){
			Feriado feriado = (Feriado)target;
				String date = String.format(feriado.getDia()+"/"+feriado.getMes()+"/"+ano); 
				try {
					feriado.ajustarData(DateUtil.formatterDDMMYYYY.parse(date));
				} catch (ParseException e) {
					e.printStackTrace();
			
			}
		}
	}
}