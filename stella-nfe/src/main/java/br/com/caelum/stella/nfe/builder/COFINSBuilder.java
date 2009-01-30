package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.cofins.COFINSNaoTributado;
import br.com.caelum.stella.nfe.builder.cofins.COFINSOutrasOperacoes;
import br.com.caelum.stella.nfe.builder.cofins.COFINSSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.cofins.COFINSTributadoPelaAliquota;
import br.com.caelum.stella.nfe.builder.cofins.COFINSTributadoPorQuantidade;
import br.com.caelum.stella.nfe.builder.cofins.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.cofins.impl.COFINSNaoTributadoImpl;
import br.com.caelum.stella.nfe.builder.cofins.impl.COFINSOutrasOperacoesImpl;
import br.com.caelum.stella.nfe.builder.cofins.impl.COFINSSubstituicaoTributariaImpl;
import br.com.caelum.stella.nfe.builder.cofins.impl.COFINSTributadoImpl;
import br.com.caelum.stella.nfe.builder.cofins.impl.COFINSTributadoPorQuantidadeImpl;

/**
 * Fabrica para cria��o dos tributos relativos a NF.
 * 
 * @author Alberto Souza
 * 
 */
public class COFINSBuilder {

    public COFINSNaoTributado cofinsAliquotaZero() {
        return new COFINSNaoTributadoImpl(SituacaoTributaria.ALIQUOTA_ZERO);
    }

    public COFINSNaoTributado cofinsComSuspensaoDaContribuicao() {
        return new COFINSNaoTributadoImpl(SituacaoTributaria.OPERACAO_COM_SUSPENSAO_DE_CONTRIBUICAO);
    }

    public COFINSNaoTributado cofinsIsentaDeContribuicao() {
        return new COFINSNaoTributadoImpl(SituacaoTributaria.OPERACAO_ISENTA_DE_CONTRIBUICAO);
    }

    public COFINSNaoTributado cofinsSemIncidenciaDaContribuicao() {
        return new COFINSNaoTributadoImpl(SituacaoTributaria.OPERACAO_SEM_INCIDENCIA_DE_CONTRIBUICAO);
    }

    public COFINSNaoTributado cofinsTributacaoMonofastica() {
        return new COFINSNaoTributadoImpl(SituacaoTributaria.TRIBUTACAO_MONOFASTICA);
    }

    public COFINSOutrasOperacoes cofinsOutrasOperacoes() {
        return new COFINSOutrasOperacoesImpl();
    }

    public COFINSSubstituicaoTributaria cofinsSubstituicaoTributaria() {
        return new COFINSSubstituicaoTributariaImpl();
    }

    public COFINSTributadoPelaAliquota cofinsAliquotaNormal() {
        return new COFINSTributadoImpl(SituacaoTributaria.ALIQUOTA_NORMAL);
    }

    public COFINSTributadoPelaAliquota cofinsAliquotaDiferenciada() {
        return new COFINSTributadoImpl(SituacaoTributaria.ALIQUOTA_DIFERENCIADA);
    }

    public COFINSTributadoPorQuantidade cofinsTributadoPorQuantidade() {
        return new COFINSTributadoPorQuantidadeImpl();
    }
}
