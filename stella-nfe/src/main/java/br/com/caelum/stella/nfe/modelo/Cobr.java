/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cobr ", propOrder = { "fat", "dup" })
@FluidName("Cobranca")
public class Cobr {

    @FluidName("Fatura")
    protected Fat fat;

    @FluidName("Duplicata")
    protected List<Dup> dup;

    public Fat getFat() {
        return fat;
    }

    public void setFat(final Fat value) {
        fat = value;
    }

    public List<Dup> getDup() {
        if (dup == null) {
            dup = new ArrayList<Dup>();
        }
        return dup;
    }

    public void setDup(final List<Dup> dups) {
        dup = dups;
    }

}