package br.com.caelum.stella.validation.ie;

import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.LeftSideZerosFormatter;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.RotinaParameters;
import br.com.caelum.stella.validation.ValidadorDeDV;

/**
 * Documentação que pode ser consultada: <a
 * href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm"
 * >http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm</a>
 * 
 * @author leobessa
 */
public class IEConstraints {

    public static final Formatter PRE_VALIDATION_FORMATTER = new LeftSideZerosFormatter(14);

    public static final Integer[] P1 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P2 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 0, 0 };

    public static final Integer[] P3 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 0, 2 };

    public static final Integer[] P4 = { 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P5 = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0 };

    public static final Integer[] P6 = { 0, 0, 0, 9, 8, 0, 0, 7, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P7 = { 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P8 = { 8, 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P9 = { 7, 6, 5, 4, 3, 2, 7, 6, 5, 4, 3, 2, 0, 0 };

    public static final Integer[] P10 = { 0, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 0, 0 };

    public static final Integer[] P11 = { 0, 3, 2, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0 };

    public static final Integer[] P12 = { 0, 0, 1, 3, 4, 5, 6, 7, 8, 10, 0, 0, 0, 0 };

    public static final Integer[] P13 = { 0, 0, 3, 2, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0 };

    public enum Rotina implements RotinaDeDigitoVerificador {
        A {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer[] a = info.getPesos();
                Integer[] b = parameter.getNumeros();
                Integer result = parameter.getResult();
                for (int i = 0; i < a.length; i++) {
                    result += (a[i] * b[i]) / 10;
                }
                return result;
            }
        },
        B {

            public Integer transform(RotinaParameters parameter) {
                return 10 * parameter.getResult();
            }
        },
        C {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer x = parameter.getResult();
                return x + (5 + 4 * info.getFator());
            }
        },
        D {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer x = parameter.getResult();
                return x % info.getMod();
            }
        },
        E {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer x = parameter.getResult();
                int result = (info.getMod()) - (x % info.getMod());
                return result;
            }
        },
        POS_IE {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer x = parameter.getResult();
                if (x == 10) {
                    x = 0;
                } else if (x == 11) {
                    x = info.getFator();
                }
                return x;
            }
        },
        POS_IE_GOIAS {
            public Integer transform(RotinaParameters parameter) {
                DigitoVerificadorInfo info = parameter.getDigitoVerificadorInfo();
                Integer x = parameter.getResult();
                if (x == 11) {
                    x = 0;
                } else if (x == 10) {
                    x = info.getFator();
                }
                return x;
            }
        };

        public abstract Integer transform(RotinaParameters parameters);

    }

    static public class Acre {
    		private static final int MOD = 11;

    	    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    	    private static final int DVX_POSITION = 1 + 13;

    	    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    	    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
    	            DVX_POSITION);


    	    private static final int DVY_POSITION = 1 + 12;

    	    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P2;

    	    private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVY_MULTIPLIERS,
    	            DVY_POSITION);

    	    public static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    	    public static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);
    }
    
    
    static public class Alagoas {
    	
    	private static final int MOD = 11;

        private static final int DVX_POSITION = 5 + 9;

        private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

        private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.B, IEConstraints.Rotina.D,
                IEConstraints.Rotina.POS_IE };

        private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
                DVX_POSITION);

        public static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);
    }
}
