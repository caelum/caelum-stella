package br.com.caelum.stella.feriado.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.com.caelum.stella.feriado.enums.Tipo;

public class TipoAdapter extends XmlAdapter<String, Tipo>{

	@Override
	public Tipo unmarshal(String v) throws Exception {
		return Tipo.getTipo(v);
	}

	@Override
	public String marshal(Tipo t) throws Exception {
		return t.toString();
	}
}