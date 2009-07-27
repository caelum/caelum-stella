package br.com.caelum.stella.nfe.proxy;

import java.util.ArrayList;
import java.util.Calendar;

import net.vidageek.fluid.proxy.FluidProxyCreator;
import net.vidageek.fluid.proxy.converter.DataConverterManager;
import net.vidageek.fluid.proxy.handler.MethodHandler;
import br.com.caelum.stella.nfe.fluid.converter.CNPJToStringConverter;
import br.com.caelum.stella.nfe.fluid.converter.CPFToStringConverter;
import br.com.caelum.stella.nfe.fluid.converter.CalendarToStringConverter;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

/**
 * @author jonasabreu
 * 
 */
final public class NFeProxyFactory {

    public <T> T createProxyFor(final Class<T> type) {
        DataConverterManager manager = new DataConverterManager();
        manager.registerConverter(Calendar.class, String.class, new CalendarToStringConverter());
        manager.registerConverter(CPF.class, String.class, new CPFToStringConverter());
        manager.registerConverter(CNPJ.class, String.class, new CNPJToStringConverter());

        Object proxy = new FluidProxyCreator(type, new ArrayList<MethodHandler>(), manager).createProxy();

        return type.cast(proxy);
    }

}
