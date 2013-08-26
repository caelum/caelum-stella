package br.com.caelum.stella.validation;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * Essa rotina é utilizada para se obter o dígito verificador de CPF, CNPJ e
 * RENAVAM.
 * 
 * @author leonardobessa
 * 
 */
@GwtCompatible
class RotinaComumDeDigitoVerificador implements RotinaDeDigitoVerificador {

    public Integer transform(RotinaParameters parameter) {
        Integer mod = parameter.getDigitoVerificadorInfo().getMod();
        Integer result = parameter.getResult() % mod;
        if (result < 2) {
            result = 0;
        } else {
            result = 11 - result;
        }
        return result;
    }
}