package br.com.caelum.stella.validation;

/**
 * Essa rotina é utilizada para se obter o dígito verificador de CPF, CNPJ e
 * RENAVAM.
 * 
 * @author leonardobessa
 * 
 */
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