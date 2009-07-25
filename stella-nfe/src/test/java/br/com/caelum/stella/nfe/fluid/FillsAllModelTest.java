package br.com.caelum.stella.nfe.fluid;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;
import net.vidageek.fluid.proxy.FluidProxyCreator;
import net.vidageek.fluid.proxy.converter.DataConverterManager;
import net.vidageek.fluid.proxy.handler.MethodHandler;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.caelum.stella.nfe.fluid.converter.CNPJToStringConverter;
import br.com.caelum.stella.nfe.fluid.converter.CPFToStringConverter;
import br.com.caelum.stella.nfe.fluid.converter.CalendarToStringConverter;
import br.com.caelum.stella.nfe.fluid.datapoints.BuilderDataPoints;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

/**
 * @author jonasabreu
 * 
 */
@RunWith(Theories.class)
final public class FillsAllModelTest implements BuilderDataPoints {

    @SuppressWarnings("unchecked")
    @Theory
    public void testThatBuilderFillsTheModel(final Class<?> builderClass) {

        DataConverterManager manager = new DataConverterManager();
        manager.registerConverter(Calendar.class, String.class, new CalendarToStringConverter());
        manager.registerConverter(CPF.class, String.class, new CPFToStringConverter());
        manager.registerConverter(CNPJ.class, String.class, new CNPJToStringConverter());

        Object proxy = new FluidProxyCreator(builderClass, new ArrayList<MethodHandler>(), manager).createProxy();
        Mirror mirror = new Mirror();

        for (Method method : mirror.on(builderClass).reflectAll().methods()) {
            if (!("build".equals(method.getName()) || "getInstance".equals(method.getName()))) {
                mirror.on(proxy).invoke().method(method).withArgs(genArgsForMethod(method));
            }
        }

        Object model = mirror.on(proxy).invoke().method("getInstance").withoutArgs();
        assertModelWasFilled(model);
    }

    private void assertModelWasFilled(final Object model) {
        Mirror mirror = new Mirror();
        for (Field field : mirror.on(model.getClass()).reflectAll().fields()) {
            Assert.assertNotNull(mirror.on(model).get().field(field));
        }
    }

    private Object[] genArgsForMethod(final Method method) {
        Object[] ret = new Object[] {};
        if (method.getParameterTypes().length != 0) {
            ret = new Object[] { genArgFor(method.getParameterTypes()[0]) };
        }
        return ret;
    }

    private Object genArgFor(final Class<?> type) {
        if (type.isEnum()) {
            return type.getEnumConstants()[0];
        } else if (String.class.isAssignableFrom(type)) {
            return "foo";
        } else if (BigInteger.class.isAssignableFrom(type)) {
            return BigInteger.TEN;
        } else if (BigDecimal.class.isAssignableFrom(type)) {
            return BigDecimal.ONE;
        } else if (Integer.class.isAssignableFrom(type)) {
            return 1;
        } else if (Long.class.isAssignableFrom(type)) {
            return 1L;
        } else if (Calendar.class.isAssignableFrom(type)) {
            return new GregorianCalendar();
        } else if (byte[].class.isAssignableFrom(type)) {
            return "bar".getBytes();
        } else if (CPF.class.isAssignableFrom(type)) {
            return new CPF("1234567891");
        } else if (CNPJ.class.isAssignableFrom(type)) {
            return new CNPJ("1234567891");
        }

        throw new IllegalArgumentException("could not generate value for type " + type.getName());
    }
}
