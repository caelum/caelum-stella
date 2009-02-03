package br.com.caelum.stella.validation;

enum Rotina implements RotinaDeDigitoVerificador {
    
    POS_PRODUTO_INTERNO {
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
}