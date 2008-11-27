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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "ide", "emit", "avulsa", "dest", "retirada", "entrega", "det", "total", "transp",
        "cobr", "infAdic", "exporta", "compra" })
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

    public void setIde(Ide value) {
        this.ide = value;
    }

    public Emit getEmit() {
        return emit;
    }

    public void setEmit(Emit value) {
        this.emit = value;
    }

    public Avulsa getAvulsa() {
        return avulsa;
    }

    public void setAvulsa(Avulsa value) {
        this.avulsa = value;
    }

    public Dest getDest() {
        return dest;
    }

    public void setDest(Dest value) {
        this.dest = value;
    }

    public TLocal getRetirada() {
        return retirada;
    }

    public void setRetirada(TLocal value) {
        this.retirada = value;
    }

    public TLocal getEntrega() {
        return entrega;
    }

    public void setEntrega(TLocal value) {
        this.entrega = value;
    }

    public List<Det> getDet() {
        if (det == null) {
            det = new ArrayList<Det>();
        }
        return this.det;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total value) {
        this.total = value;
    }

    public Transp getTransp() {
        return transp;
    }

    public void setTransp(Transp value) {
        this.transp = value;
    }

    public Cobr getCobr() {
        return cobr;
    }

    public void setCobr(Cobr value) {
        this.cobr = value;
    }

    public InfAdic getInfAdic() {
        return infAdic;
    }

    public void setInfAdic(InfAdic value) {
        this.infAdic = value;
    }

    public Exporta getExporta() {
        return exporta;
    }

    public void setExporta(Exporta value) {
        this.exporta = value;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra value) {
        this.compra = value;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String value) {
        this.versao = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}