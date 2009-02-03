package br.com.caelum.stella.tinytype;

/**
 * Representa um CPF (Cadastro de Pessoas Física).
 * 
 * @author leobessa
 * 
 */
public final class CPF {

    private final String numero;

    /**
     * @param numero
     *            do CPF
     */
    public CPF(String numero) {
        this.numero = numero;
    }

    /**
     * @return número do CPF
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return número do CPF.
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
        final CPF other = (CPF) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

}
