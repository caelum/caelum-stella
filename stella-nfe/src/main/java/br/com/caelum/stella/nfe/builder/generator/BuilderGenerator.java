package br.com.caelum.stella.nfe.builder.generator;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.vidageek.fluid.generator.Fluid;
import br.com.caelum.stella.nfe.modelo.*;

/**
 * @author jonasabreu
 * 
 */
final public class BuilderGenerator {
    private static final String PACKAGE = "br.com.caelum.stella.nfe.fluid";
    private static final Pattern PATTERN = Pattern.compile("public interface (.*?)<T>");

    public static void main(final String[] args) throws Throwable {
        Set<Class<?>> set = new HashSet<Class<?>>();
        Class<?> classes[] = { Adi.class, Arma.class, Avulsa.class, CabecMsg.class, CanonicalizationMethod.class,
                CIDE.class, Cobr.class, COFINS.class, COFINSAliq.class, COFINSNT.class, COFINSOutr.class,
                COFINSQtde.class, COFINSST.class, Comb.class, Compra.class, Dest.class, Det.class, DFe.class, DI.class,
                DigestMethod.class, Dup.class, Emit.class, Exclui.class, Exporta.class, Fat.class, ICMS.class,
                ICMS00.class, ICMS10.class, ICMS20.class, ICMS30.class, ICMS40.class, ICMS51.class, ICMS60.class,
                ICMS70.class, ICMS90.class, ICMSComb.class, ICMSCons.class, ICMSInter.class, ICMSTot.class, Ide.class,
                II.class, Imposto.class, InfAdic.class, InfAtuCadEmiDFe.class, InfCad.class, InfCadEmiDFe.class,
                InfCanc.class, InfCons.class, InfInut.class, InfNFe.class, InfProt.class, InfRec.class,
                InfRetAtuCadEmiDFe.class, IPI.class, IPINT.class, IPITrib.class, ISSQN.class, ISSQNtot.class,
                KeyInfoType.class, Lacres.class, Med.class, NFref.class, ObjectFactory.class, ObsCont.class,
                ObsFisco.class, PIS.class, PISAliq.class, PISNT.class, PISOutr.class, PISQtde.class, PISST.class,
                ProcRef.class, Prod.class, ReferenceType.class, RefNF.class, RetTransp.class, RetTrib.class,
                SignatureMethod.class, SignatureType.class, SignatureValueType.class, SignedInfoType.class,
                TAtuCadEmiDFe.class, TCadEmiDFe.class, TCancNFe.class, TConsCad.class, TConsReciNFe.class,
                TConsSitNFe.class, TConsStatServ.class, TEmissor.class, TEndereco.class, TEnviNFe.class,
                TInutNFe.class, TLocal.class, TNFe.class, TNfeProc.class, Total.class, TProcCancNFe.class,
                TProcInutNFe.class, TProtNFe.class, TransformsType.class, TransformType.class, Transp.class,
                Transporta.class, TRetAtuCadEmiDFe.class, TRetCancNFe.class, TRetConsCad.class, TRetConsReciNFe.class,
                TRetConsSitNFe.class, TRetConsStatServ.class, TRetEnviNFe.class, TRetInutNFe.class, TVeiculo.class,
                VeicProd.class, Vol.class, X509DataType.class };

        set.addAll(Arrays.asList(classes));

        for (Class<?> type : set) {
            String code = new Fluid(type, PACKAGE).generateInterface(set);
            System.out.println("Writing interface " + getInterfaceName(code));
            PrintWriter writer = new PrintWriter("stella-nfe/src/main/java/" + PACKAGE.replaceAll("\\.", "\\/") + "/"
                    + getInterfaceName(code) + ".java");
            writer.print(code);
            writer.close();
        }

    }

    private static String getInterfaceName(final String code) {
        Matcher matcher = PATTERN.matcher(code);
        matcher.find();
        return matcher.group(1);
    }
}
