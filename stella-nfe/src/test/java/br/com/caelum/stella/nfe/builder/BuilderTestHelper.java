package br.com.caelum.stella.nfe.builder;

import java.lang.reflect.Field;

import net.vidageek.mirror.Mirror;

import org.junit.Assert;

import br.com.caelum.stella.nfe.ObjectCreator;

public class BuilderTestHelper {

    public static void assertModelWasFilled(final Object target) {
        Object instance = ((ObjectCreator) target).getInstance();
        for (Field field : Mirror.on(instance.getClass()).reflectAll().fields()) {
            Assert.assertNotNull("O campo " + field.getName() + " da classe " + target.getClass()
                    + " deveria ter sido preenchido.", Mirror.on(instance).get().field(field));
        }
    }

}
