package br.com.caelum.stella.nfe.builder.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import net.vidageek.mirror.Mirror;
import br.com.caelum.stella.nfe.modelo.CabecMsg;
import br.com.caelum.stella.nfe.modelo.DFe;
import br.com.caelum.stella.nfe.modelo.Exclui;
import br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.InfCad;
import br.com.caelum.stella.nfe.modelo.InfCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.InfCanc;
import br.com.caelum.stella.nfe.modelo.InfCons;
import br.com.caelum.stella.nfe.modelo.InfInut;
import br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TAtuCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TCancNFe;
import br.com.caelum.stella.nfe.modelo.TConsCad;
import br.com.caelum.stella.nfe.modelo.TConsSitNFe;
import br.com.caelum.stella.nfe.modelo.TConsStatServ;
import br.com.caelum.stella.nfe.modelo.TEmissor;
import br.com.caelum.stella.nfe.modelo.TInutNFe;
import br.com.caelum.stella.nfe.modelo.TProcCancNFe;
import br.com.caelum.stella.nfe.modelo.TProcInutNFe;
import br.com.caelum.stella.nfe.modelo.TRetAtuCadEmiDFe;
import br.com.caelum.stella.nfe.modelo.TRetCancNFe;
import br.com.caelum.stella.nfe.modelo.TRetConsCad;
import br.com.caelum.stella.nfe.modelo.TRetConsSitNFe;
import br.com.caelum.stella.nfe.modelo.TRetConsStatServ;
import br.com.caelum.stella.nfe.modelo.TRetInutNFe;
import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.nfe.modelo.TUfCons;

/**
 * @author jonasabreu
 * 
 *         Objeto que usa um pouco de magia preta pra gerar um builder a partir
 *         dos fields de um objeto.
 */
final public class JAXBBuilderCodeGenerator {

    private static boolean enableFileGeneration = true;

    public static void main(final String[] args) throws IOException {
        Class<?>[] sources = { CabecMsg.class, TInutNFe.class, TProcCancNFe.class, TProcInutNFe.class,
                TRetAtuCadEmiDFe.class, TRetCancNFe.class, TRetConsCad.class, TRetConsSitNFe.class,
                TRetConsStatServ.class, TRetInutNFe.class, TUf.class, TUfCons.class, DFe.class, Exclui.class,
                InfAtuCadEmiDFe.class, InfCad.class, InfCadEmiDFe.class, InfCanc.class, InfCons.class, InfInut.class,
                InfRetAtuCadEmiDFe.class, TAtuCadEmiDFe.class, TCadEmiDFe.class, TCancNFe.class, TConsCad.class,
                TConsSitNFe.class, TConsStatServ.class, TEmissor.class };
        generateBuilderFor(sources);
    }

    private static void generateBuilderFor(final Class<?>... sources) throws FileNotFoundException {
        for (Class<?> type : sources) {
            generateBuilderFor(type);
        }
    }

    private static void generateBuilderFor(final Class<?> source) throws FileNotFoundException {
        ClassObject clazz = new ClassObject(source);

        List<Field> fields = Mirror.on(source).reflectAll().fields();
        for (Field field : fields) {
            String name = field.getName();
            XmlElement annotation = field.getAnnotation(XmlElement.class);
            if ((annotation != null) && !"##default".equals(annotation.name())) {
                name = annotation.name();
            }
            clazz.addMethod(name, field.getType());
        }

        clazz.setPackageName("br.com.caelum.stella.nfe.builder.generated2");

        String mainPath = "stella-nfe/src/main/java/";
        String testPath = "stella-nfe/src/test/java/";
        String packagePath = clazz.getPackageName().replace('.', '/') + "/";
        String extension = ".java";
        String implementationPathName = mainPath + packagePath + clazz.getImplementationName() + extension;
        String interfacePathName = mainPath + packagePath + clazz.getInterfaceName() + extension;
        String interfaceTestPathName = testPath + packagePath + clazz.getInterfaceTestName() + extension;

        generateSourceCode(clazz.getInterface(), interfacePathName);
        generateSourceCode(clazz.getImplementation(), implementationPathName);
        generateSourceCode(clazz.getInterfaceTest(), interfaceTestPathName);

        System.out.println(clazz.getInterface());
        System.out.println(clazz.getImplementation());
        System.out.println(clazz.getInterfaceTest());
    }

    private static void generateSourceCode(final String code, final String pathName) throws FileNotFoundException {
        if (enableFileGeneration) {
            File impl = new File(pathName);
            PrintStream implPrintStream = new PrintStream(impl);
            implPrintStream.print(code);
        }
    }

}
