package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.format.CEPFormatter;

/**
 * @author Edenir Norberto Anschau
 *
 */
public class CEP {

    private String numero;
    private String numeroFormatado;

    public CEP(String numero) {
        CEPFormatter formatador = new CEPFormatter();
        if (formatador.isFormatted(numero)) {
            this.numero = formatador.unformat(numero);
            this.numeroFormatado = numero;
        } else if (formatador.canBeFormatted(numero)) {
            this.numero = numero;
            this.numeroFormatado = formatador.format(numero);
        } else {
            this.numero = this.numeroFormatado = numero;
        }
    }

    public String getNumero() {
        return numero;
    }

    public String getNumeroFormatado() {
        return numeroFormatado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CEP other = (CEP) obj;
        if (numero == null) {
            if (other.numero != null) {
                return false;
            }
        } else if (!numero.equals(other.numero)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return getNumeroFormatado();
    }

}