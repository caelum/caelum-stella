package br.com.caelum.stella.validation;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * @author Leonardo Bessa
 */
@GwtCompatible
public interface RotinaDeDigitoVerificador {
    Integer transform(RotinaParameters parameters);
}