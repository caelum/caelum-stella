package br.com.caelum.stella.nfe.builder.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import net.vidageek.mirror.Mirror;
import br.com.caelum.stella.nfe.modelo.Adi;
import br.com.caelum.stella.nfe.modelo.Arma;
import br.com.caelum.stella.nfe.modelo.Avulsa;
import br.com.caelum.stella.nfe.modelo.CIDE;
import br.com.caelum.stella.nfe.modelo.COFINS;
import br.com.caelum.stella.nfe.modelo.COFINSAliq;
import br.com.caelum.stella.nfe.modelo.COFINSNT;
import br.com.caelum.stella.nfe.modelo.COFINSOutr;
import br.com.caelum.stella.nfe.modelo.COFINSQtde;
import br.com.caelum.stella.nfe.modelo.COFINSST;
import br.com.caelum.stella.nfe.modelo.Cobr;
import br.com.caelum.stella.nfe.modelo.Comb;
import br.com.caelum.stella.nfe.modelo.Compra;
import br.com.caelum.stella.nfe.modelo.DI;
import br.com.caelum.stella.nfe.modelo.Dest;
import br.com.caelum.stella.nfe.modelo.Det;
import br.com.caelum.stella.nfe.modelo.Dup;
import br.com.caelum.stella.nfe.modelo.Emit;
import br.com.caelum.stella.nfe.modelo.Exporta;
import br.com.caelum.stella.nfe.modelo.Fat;
import br.com.caelum.stella.nfe.modelo.ICMSComb;
import br.com.caelum.stella.nfe.modelo.ICMSCons;
import br.com.caelum.stella.nfe.modelo.ICMSInter;
import br.com.caelum.stella.nfe.modelo.ICMSTot;
import br.com.caelum.stella.nfe.modelo.IPI;
import br.com.caelum.stella.nfe.modelo.IPINT;
import br.com.caelum.stella.nfe.modelo.IPITrib;
import br.com.caelum.stella.nfe.modelo.ISSQN;
import br.com.caelum.stella.nfe.modelo.ISSQNtot;
import br.com.caelum.stella.nfe.modelo.Ide;
import br.com.caelum.stella.nfe.modelo.Imposto;
import br.com.caelum.stella.nfe.modelo.InfAdic;
import br.com.caelum.stella.nfe.modelo.InfNFe;
import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.InfRec;
import br.com.caelum.stella.nfe.modelo.Lacres;
import br.com.caelum.stella.nfe.modelo.Med;
import br.com.caelum.stella.nfe.modelo.NFref;
import br.com.caelum.stella.nfe.modelo.ObsCont;
import br.com.caelum.stella.nfe.modelo.ObsFisco;
import br.com.caelum.stella.nfe.modelo.PIS;
import br.com.caelum.stella.nfe.modelo.PISAliq;
import br.com.caelum.stella.nfe.modelo.PISNT;
import br.com.caelum.stella.nfe.modelo.PISOutr;
import br.com.caelum.stella.nfe.modelo.PISQtde;
import br.com.caelum.stella.nfe.modelo.PISST;
import br.com.caelum.stella.nfe.modelo.ProcRef;
import br.com.caelum.stella.nfe.modelo.Prod;
import br.com.caelum.stella.nfe.modelo.RefNF;
import br.com.caelum.stella.nfe.modelo.RetTransp;
import br.com.caelum.stella.nfe.modelo.RetTrib;
import br.com.caelum.stella.nfe.modelo.SignatureMethod;
import br.com.caelum.stella.nfe.modelo.SignatureType;
import br.com.caelum.stella.nfe.modelo.SignatureValueType;
import br.com.caelum.stella.nfe.modelo.SignedInfoType;
import br.com.caelum.stella.nfe.modelo.TConsReciNFe;
import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TEnviNFe;
import br.com.caelum.stella.nfe.modelo.TLocal;
import br.com.caelum.stella.nfe.modelo.TNFe;
import br.com.caelum.stella.nfe.modelo.TNfeProc;
import br.com.caelum.stella.nfe.modelo.TProtNFe;
import br.com.caelum.stella.nfe.modelo.TRetConsReciNFe;
import br.com.caelum.stella.nfe.modelo.TRetEnviNFe;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.nfe.modelo.TVeiculo;
import br.com.caelum.stella.nfe.modelo.Total;
import br.com.caelum.stella.nfe.modelo.TransformType;
import br.com.caelum.stella.nfe.modelo.TransformsType;
import br.com.caelum.stella.nfe.modelo.Transp;
import br.com.caelum.stella.nfe.modelo.Transporta;
import br.com.caelum.stella.nfe.modelo.VeicProd;
import br.com.caelum.stella.nfe.modelo.Vol;

/**
 * @author jonasabreu
 * 
 *         Objeto que usa um pouco de magia preta pra gerar um builder a partir
 *         dos fields de um objeto.
 */
final public class JAXBBuilderCodeGenerator {

    private static boolean enableFileGeneration = true;

    public static void main(final String[] args) throws IOException {
        Class<?>[] sources = { Adi.class, Arma.class, Avulsa.class, CIDE.class, Cobr.class, COFINS.class,
                COFINSAliq.class, COFINSNT.class, COFINSOutr.class, COFINSQtde.class, COFINSST.class, Comb.class,
                Compra.class, Dest.class, Det.class, DI.class, Dup.class, Emit.class, Exporta.class, Fat.class,
                ICMSComb.class, ICMSCons.class, ICMSInter.class, ICMSTot.class, Ide.class, Imposto.class,
                InfAdic.class, InfNFe.class, InfProt.class, InfRec.class, IPI.class, IPINT.class, IPITrib.class,
                ISSQN.class, ISSQNtot.class, Lacres.class, Med.class, NFref.class, ObsCont.class, ObsFisco.class,
                PIS.class, PISAliq.class, PISNT.class, PISOutr.class, PISQtde.class, PISST.class, ProcRef.class,
                Prod.class, RefNF.class, RetTransp.class, RetTrib.class, SignatureMethod.class, SignatureType.class,
                SignatureValueType.class, SignedInfoType.class, TConsReciNFe.class, TEndereco.class, TEnviNFe.class,
                TLocal.class, TNFe.class, TNfeProc.class, Total.class, TProtNFe.class, TransformsType.class,
                TransformType.class, Transp.class, Transporta.class, TRetConsReciNFe.class, TRetEnviNFe.class,
                UF.class, TVeiculo.class, VeicProd.class, Vol.class,

        };
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

        clazz.setPackageName("br.com.caelum.stella.nfe.builder.generated");

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
