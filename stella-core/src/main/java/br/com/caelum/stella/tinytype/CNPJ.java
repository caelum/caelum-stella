package br.com.caelum.stella.tinytype;

/**
 * Representa um Cadastro Nacional da Pessoa Jurídica - CNPJ.
 * 
 * @author leobessa
 * 
 */
public final class CNPJ {

    private final String numero;

    /**
     * @param numero
     *            do CNPJ
     */
    public CNPJ(String numero) {
        this.numero = numero;
    }

    /**
     * @return número do CNPJ.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return número do CNPJ.
     */
    @Override
    public String toString() {
        return numero;
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CNPJ other = (CNPJ) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

}
