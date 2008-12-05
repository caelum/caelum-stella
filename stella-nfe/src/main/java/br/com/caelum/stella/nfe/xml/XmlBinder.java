package br.com.caelum.stella.nfe.xml;

public interface XmlBinder {

    public <T> T unmarshal(final Class<T> contextClazz, final String toUnmarshal);

    public String marshal(Object toMarshal);

}
