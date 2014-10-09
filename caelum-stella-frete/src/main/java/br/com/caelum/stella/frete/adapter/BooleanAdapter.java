package br.com.caelum.stella.frete.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter  extends XmlAdapter<String, Boolean>{

	@Override
	public Boolean unmarshal(String v) throws Exception {
		 return v.equalsIgnoreCase("S");
	}

	@Override
	public String marshal(Boolean v) throws Exception {
		return v.toString();
	}
}