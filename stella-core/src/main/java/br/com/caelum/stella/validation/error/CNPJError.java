package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.InvalidValue;

/**
 * 
 * Representa possíveis erros do CNPJ
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
@GwtCompatible
public enum CNPJError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_DIGITS, INVALID_FORMAT
}
