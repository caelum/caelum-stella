package br.com.caelum.stella.frete.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.com.caelum.stella.frete.enums.Servico;

public class ServicoAdapter extends XmlAdapter<String, Servico>{

	@Override
	public Servico unmarshal(String v) throws Exception {
		return Servico.getServico(v);
	}

	@Override
	public String marshal(Servico v) throws Exception {
		return v.toString();
	}
}