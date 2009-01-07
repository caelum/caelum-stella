package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.TributacaoICMS;

/**
 * 
 * @author jonasabreu
 * 
 */
public interface ICMSNaoTributado extends ICMS {

    public ICMSNaoTributado withOrigem(OrigemICMS origem) ;

    public ICMSNaoTributado withTributacao(TributacaoICMS tributacao) ;
}
