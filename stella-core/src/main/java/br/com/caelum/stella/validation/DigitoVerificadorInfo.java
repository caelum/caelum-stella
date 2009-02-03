package br.com.caelum.stella.validation;

/**
 * Representa as informações sobre um Dígito Verificador.
 * 
 * @author leobessa
 * 
 */
public class DigitoVerificadorInfo {
    private final Integer fator;

    private final RotinaDeDigitoVerificador[] rotinas;

    private final Integer mod;

    private final Integer[] pesos;

    private final Integer posicaoDoDv;

    public DigitoVerificadorInfo(Integer fator, RotinaDeDigitoVerificador[] rotinas, Integer mod, Integer[] pesos,
            Integer posicaoDoDv) {
        this.fator = fator;
        this.rotinas = rotinas;
        this.mod = mod;
        this.pesos = pesos;
        this.posicaoDoDv = posicaoDoDv;
    }

    public Integer getFator() {
        return fator;
    }

    public RotinaDeDigitoVerificador[] getRotinas() {
        return rotinas;
    }

    public Integer getMod() {
        return mod;
    }

    public Integer[] getPesos() {
        return pesos;
    }

    public Integer getPosicaoDoDv() {
        return posicaoDoDv;
    }
}