package br.com.caelum.stella.nfe.fluid.converter;

import net.vidageek.fluid.proxy.converter.DataConverter;
import br.com.caelum.stella.tinytype.CPF;

/**
 * @author jonasabreu
 * 
 */
final public class CPFToStringConverter implements DataConverter<CPF, String> {

    public String convert(final CPF object) {
        return object.getNumero();
    }

}
