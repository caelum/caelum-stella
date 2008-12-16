package br.com.caelum.stella.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.caelum.stella.validation.ie.IEConstraints;

public class ValidadorDeDVTest {

    @Test
    public void testDVisWithValidRJSample() {
        Integer posicaoDoDv = 14;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };
        Integer[] pesos = IEConstraints.P8;
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00000080336012");
        assertTrue(dvIsValid);
    }

    @Test
    public void testDVisWithInvalidRJSample() {
        Integer posicaoDoDv = 14;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };
        Integer[] pesos = IEConstraints.P8;
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00000080336013");
        assertFalse(dvIsValid);
    }

    @Test
    public void testDVisWithValidRJSample2() {
        Integer posicaoDoDv = 14;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };
        Integer[] pesos = IEConstraints.P8;
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00000084920045");
        assertTrue(dvIsValid);
    }

    @Test
    public void testDVisWithInvalidRJSample2() {
        Integer posicaoDoDv = 14;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };
        Integer[] pesos = IEConstraints.P8;
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00000084920048");
        assertFalse(dvIsValid);
    }

    @Test
    public void testDVXisValidwithValidSPSample() {
        Integer posicaoDoDv = 11;
        Integer[] pesos = IEConstraints.P12;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00417032057114");
        assertTrue(dvIsValid);
    }

    @Test
    public void testDVYisValidwithValidSPSample() {
        Integer posicaoDoDv = 14;
        Integer[] pesos = IEConstraints.P13;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00417032057114");
        assertTrue(dvIsValid);
    }

    @Test
    public void testDVXisValidwithInvalidSPSample() {
        Integer posicaoDoDv = 11;
        Integer[] pesos = IEConstraints.P12;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00417032050114");
        assertFalse(dvIsValid);
    }

    @Test
    public void testDVYisValidwithInvalidSPSample() {
        Integer posicaoDoDv = 14;
        Integer[] pesos = IEConstraints.P13;
        Integer fator = 0;
        Integer mod = 11;
        RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.D, IEConstraints.Rotina.POS_IE };
        DigitoVerificadorInfo info = new DigitoVerificadorInfo(fator, rotinas, mod, pesos, posicaoDoDv);
        ValidadorDeDV verificador = new ValidadorDeDV(info);
        boolean dvIsValid = verificador.isDVValid("00417032057116");
        assertFalse(dvIsValid);
    }

}
