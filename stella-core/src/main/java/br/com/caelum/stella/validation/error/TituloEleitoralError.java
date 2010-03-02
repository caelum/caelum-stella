package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * 
 * Representa possíveis erros do Titulo de Eleitor.
 * 
 * @author Leonardo Bessa
 */
public enum TituloEleitoralError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_FORMAT,INVALID_DIGITS, INVALID_CODIGO_DE_ESTADO
}
