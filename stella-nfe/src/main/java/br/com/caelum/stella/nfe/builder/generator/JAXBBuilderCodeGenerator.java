package br.com.caelum.stella.nfe.builder.generator;

import java.lang.reflect.Field;
import java.util.List;

import net.vidageek.mirror.Mirror;
import br.com.caelum.stella.nfe.modelo.Adi;

/**
 * @author jonasabreu
 * 
 *         Objeto que usa um pouco de magia preta pra gerar um builder a partir
 *         dos fields de um objeto.
 */
final public class JAXBBuilderCodeGenerator {

    private static final Class<?> source = Adi.class;

    public static void main(final String[] args) {

        ClassObject clazz = new ClassObject(source);

        List<Field> fields = Mirror.on(source).reflectAll().fields();
        for (Field field : fields) {
            clazz.addMethod(field.getName(), field.getType());
        }

        System.out.println(clazz.getInterface());
        System.out.println(clazz.getImplentation());

    }

}
