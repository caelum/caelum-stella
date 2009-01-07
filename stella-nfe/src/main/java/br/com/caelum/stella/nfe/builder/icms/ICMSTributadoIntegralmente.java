package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public interface ICMSTributadoIntegralmente extends ICMS {

    public ICMSTributadoIntegralmente withOrigem(final OrigemICMS origem) ;

    public ICMSTributadoIntegralmente withModalidade(final ModalidadeBaseCalculo modalidade) ;

    public ICMSTributadoIntegralmente withBaseDeCalculo(final BigDecimal baseDeCalculo) ;

    public ICMSTributadoIntegralmente withAliquota(final BigDecimal aliquota) ;

    public ICMSTributadoIntegralmente withValor(final BigDecimal valor) ;

}
