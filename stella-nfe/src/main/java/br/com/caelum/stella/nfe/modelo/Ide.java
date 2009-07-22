/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;
import br.com.caelum.stella.nfe.builder.enums.TipoDoAmbiente;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ide ", propOrder = { "cuf", "cnf", "natOp", "indPag", "mod", "serie", "nnf", "dEmi", "dSaiEnt",
        "tpNF", "cMunFG", "nFref", "tpImp", "tpEmis", "cdv", "tpAmb", "finNFe", "procEmi", "verProc" })
@FluidName("IdentificacaoDaNFE")
public class Ide {

    @XmlElement(name = "cUF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoUFDoEmitente")
    protected String cuf;

    @XmlElement(name = "cNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDaNF")
    @FluidDataType(Integer.class)
    protected String cnf;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("descricaoDaNaturezaDaOperacao")
    protected String natOp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("formaDePagamento")
    protected String indPag;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("modeloDoDocumentoFiscal")
    protected String mod;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("serie")
    protected String serie;

    @XmlElement(name = "nNF", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDoDocumentoFiscal")
    protected String nnf;

    @XmlElement(required = true)
    @FluidName("dataDeEmissao")
    @FluidDataType(Calendar.class)
    protected String dEmi;

    @FluidName("dataDeSaidaOuEntrada")
    @FluidDataType(Calendar.class)
    protected String dSaiEnt;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDoDocumentoFiscal")
    protected String tpNF;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDoMunicipioDeOcorrenciaDoFatoGerador")
    protected String cMunFG;

    @XmlElement(name = "NFref")
    @FluidName("informacoesDaNFReferenciada")
    protected List<NFref> nFref;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("formatoDeImpressao")
    protected String tpImp;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("formaDeEmissao")
    protected String tpEmis;

    @XmlElement(name = "cDV", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("digitoVerificadorDaChaveDeAcessoDaNFE")
    protected String cdv;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("tipoDoAmbiente")
    @FluidDataType(TipoDoAmbiente.class)
    protected String tpAmb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("finalidadeDaEmissaoDaNFE")
    protected String finNFe;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("processoDeEmissao")
    protected String procEmi;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("versaoDoAplicativoUsadoNaEmissao")
    protected String verProc;

    public String getCUF() {
        return cuf;
    }

    public void setCUF(final String value) {
        cuf = value;
    }

    public String getCNF() {
        return cnf;
    }

    public void setCNF(final String value) {
        cnf = value;
    }

    public String getNatOp() {
        return natOp;
    }

    public void setNatOp(final String value) {
        natOp = value;
    }

    public String getIndPag() {
        return indPag;
    }

    public void setIndPag(final String value) {
        indPag = value;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(final String value) {
        mod = value;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(final String value) {
        serie = value;
    }

    public String getNNF() {
        return nnf;
    }

    public void setNNF(final String value) {
        nnf = value;
    }

    public String getDEmi() {
        return dEmi;
    }

    public void setDEmi(final Calendar calendar) {
        dEmi = calendar.toString(); // TODO formatar isso
    }

    public String getDSaiEnt() {
        return dSaiEnt;
    }

    public void setDSaiEnt(final Calendar calendar) {
        dSaiEnt = calendar.toString(); // TODO formatar isso
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(final String value) {
        tpNF = value;
    }

    public String getCMunFG() {
        return cMunFG;
    }

    public void setCMunFG(final String value) {
        cMunFG = value;
    }

    public List<NFref> getNFref() {
        if (nFref == null) {
            nFref = new ArrayList<NFref>();
        }
        return nFref;
    }

    public String getTpImp() {
        return tpImp;
    }

    public void setTpImp(final String value) {
        tpImp = value;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(final String value) {
        tpEmis = value;
    }

    public String getCDV() {
        return cdv;
    }

    public void setCDV(final String value) {
        cdv = value;
    }

    public String getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(final String value) {
        tpAmb = value;
    }

    public String getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(final String value) {
        finNFe = value;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(final String value) {
        procEmi = value;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(final String value) {
        verProc = value;
    }

    public void setNFref(final List<NFref> nfref) {
        nFref = nfref;
    }

}