/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfNFe ", propOrder = { "ide", "emit", "avulsa", "dest", "retirada", "entrega", "det", "total",
        "transp", "cobr", "infAdic", "exporta", "compra" })
@FluidName("InformacoesDaNFE")
public class InfNFe {

    @XmlElement(required = true)
    protected Ide ide;

    @XmlElement(required = true)
    protected Emit emit;

    protected Avulsa avulsa;

    @XmlElement(required = true)
    protected Dest dest;

    protected TLocal retirada;

    protected TLocal entrega;

    @XmlElement(required = true)
    protected List<Det> det;

    @XmlElement(required = true)
    protected Total total;

    @XmlElement(required = true)
    protected Transp transp;

    protected Cobr cobr;

    protected InfAdic infAdic;

    protected Exporta exporta;

    protected Compra compra;

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public Ide getIde() {
        return ide;
    }

    public void setIde(final Ide value) {
        ide = value;
    }

    public Emit getEmit() {
        return emit;
    }

    public void setEmit(final Emit value) {
        emit = value;
    }

    public Avulsa getAvulsa() {
        return avulsa;
    }

    public void setAvulsa(final Avulsa value) {
        avulsa = value;
    }

    public Dest getDest() {
        return dest;
    }

    public void setDest(final Dest value) {
        dest = value;
    }

    public TLocal getRetirada() {
        return retirada;
    }

    public void setRetirada(final TLocal value) {
        retirada = value;
    }

    public TLocal getEntrega() {
        return entrega;
    }

    public void setEntrega(final TLocal value) {
        entrega = value;
    }

    public List<Det> getDet() {
        if (det == null) {
            det = new ArrayList<Det>();
        }
        return det;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(final Total value) {
        total = value;
    }

    public Transp getTransp() {
        return transp;
    }

    public void setTransp(final Transp value) {
        transp = value;
    }

    public Cobr getCobr() {
        return cobr;
    }

    public void setCobr(final Cobr value) {
        cobr = value;
    }

    public InfAdic getInfAdic() {
        return infAdic;
    }

    public void setInfAdic(final InfAdic value) {
        infAdic = value;
    }

    public Exporta getExporta() {
        return exporta;
    }

    public void setExporta(final Exporta value) {
        exporta = value;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(final Compra value) {
        compra = value;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(final String value) {
        versao = value;
    }

    public String getId() {
        return id;
    }

    public void setId(final String value) {
        id = value;
    }

    public void setDet(final List<Det> det) {
        this.det = det;
    }

}