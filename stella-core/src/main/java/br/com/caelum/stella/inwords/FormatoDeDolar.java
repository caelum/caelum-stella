package br.com.caelum.stella.inwords;

/**
 * Representa o formato para números em dólares com até duas casas decimais.
 *
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class FormatoDeDolar implements FormatoDeExtenso {
	@Override
    public String getUnidadeInteiraNoSingular() {
        return "dollar";
    }

	@Override
    public String getUnidadeInteiraNoPlural() {
        return "dollars";
    }

	@Override
    public String getUnidadeDecimalNoSingular() {
        return "cent";
    }

	@Override
	public String getUnidadeDecimalNoPlural() {
        return "cents";
    }

	@Override
    public int getCasasDecimais() {
        return 2;
    }
}
