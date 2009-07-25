package br.com.caelum.stella.nfe.fluid.converter;

import net.vidageek.fluid.proxy.converter.DataConverter;
import br.com.caelum.stella.tinytype.CNPJ;

/**
 * @author jonasabreu
 * 
 */
final public class CNPJToStringConverter implements DataConverter<CNPJ, String> {

    public String convert(final CNPJ object) {
        return object.getNumero();
    }

}
