package br.com.caelum.stella.boleto.bancos.gerador;

import br.com.caelum.stella.DigitoPara;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * Gerador de dígitos do Bradesco.
 * <p>
 * O dígito de auto-conferência do Nosso Número é calculado acrescentando o número da
 * carteira à esquerda do Nosso Número e aplicando o módulo 11 com base 7 (pesos 2 a 7,
 * da direita para a esquerda). Quando o resto da divisão for 1, o dígito é "P";
 * quando o resto for 0, o dígito é 0.
 *
 * @see <a href="https://www.bradesco.com.br/arquivos/layout-cobranca.pdf">Manual de layout de cobrança do Bradesco</a>
 */
public class GeradorDeDigitoBradesco extends GeradorDeDigitoPadrao {

    private static final long serialVersionUID = 1L;

    /**
     * Calcula o dígito de auto-conferência do Nosso Número do Bradesco.
     *
     * @param carteira     número da carteira (será completado com zeros à esquerda até 2 dígitos)
     * @param nossoNumero  nosso número (será completado com zeros à esquerda até 11 dígitos)
     * @return o dígito de auto-conferência ("0" a "9" ou "P")
     */
    public String calculaDVNossoNumero(String carteira, String nossoNumero) {
        DigitoPara digitoPara = new DigitoPara(
                leftPadWithZeros(carteira, 2) + leftPadWithZeros(nossoNumero, 11));
        return digitoPara.comMultiplicadoresDeAte(2, 7)
                .complementarAoModulo()
                .mod(11)
                .trocandoPorSeEncontrar("0", 11)
                .trocandoPorSeEncontrar("P", 10)
                .calcula();
    }
}
