package br.com.caelum.stella.frete.adapter;

import java.text.NumberFormat;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String,Double> {
	private static NumberFormat formatter = NumberFormat.getInstance(new Locale("pt","BR"));
	
	@Override
	public String marshal(Double v) throws Exception {
			return formatter.format(v);
	}
	
	@Override
	public Double unmarshal(String v) throws Exception {
			return formatter.parse(v).doubleValue();
	}
}
