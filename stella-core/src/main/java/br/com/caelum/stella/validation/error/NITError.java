package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.annotations.GwtCompatible;
import br.com.caelum.stella.validation.InvalidValue;

/**
 * Representa possíveis erros da validação do PIS
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
@GwtCompatible
public enum NITError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_DIGITS, REPEATED_DIGITS, INVALID_FORMAT
}
