package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.enums.OrigemICMS;

public interface ICMSDiferimento extends ICMS {

    public ICMSDiferimento withOrigem(OrigemICMS origem) ;

    public ICMSDiferimento withModalidade(ModalidadeBaseCalculo modalidade) ;

    public ICMSDiferimento withPercentualReducaoBaseCalculo(BigDecimal percentualReducaoBaseCalculo) ;

    public ICMSDiferimento withBaseCalculo(BigDecimal baseCalculo) ;

    public ICMSDiferimento withAliquota(BigDecimal aliquota) ;

    public ICMSDiferimento withValor(BigDecimal valor) ;

}
