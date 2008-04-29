package br.com.caelum.stella.validation.ie;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.stella.validation.ie.CalculoDVInfo.RotinaCode;

public class CalculoDVInfoTest {
	
	@Test
	public void testDVisWithValidRJSample() {
		Integer posicaoDoDv = 14;
		int pesoCode = 8;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.E};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00000080336012");
		assertTrue(dvIsValid);
	}
	
	@Test
	public void testDVisWithInvalidRJSample() {
		Integer posicaoDoDv = 14;
		int pesoCode = 8;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.E};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00000080336013");
		assertFalse(dvIsValid);
	}
	
	@Test
	public void testDVisWithValidRJSample2() {
		Integer posicaoDoDv = 14;
		int pesoCode = 8;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.E};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00000084920045");
		assertTrue(dvIsValid);
	}
	
	@Test
	public void testDVisWithInvalidRJSample2() {
		Integer posicaoDoDv = 14;
		int pesoCode = 8;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.E};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00000084920048");
		assertFalse(dvIsValid);
	}
	
	@Test
	public void testDVXisValidwithValidSPSample() {
		Integer posicaoDoDv = 11;
		int pesoCode = 12;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.D};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00417032057114");
		assertTrue(dvIsValid);
	}
	
	@Test
	public void testDVYisValidwithValidSPSample() {
		Integer posicaoDoDv = 14;
		int pesoCode = 13;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.D};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00417032057114");
		assertTrue(dvIsValid);
	}
	
	@Test
	public void testDVXisValidwithInvalidSPSample() {
		Integer posicaoDoDv = 11;
		int pesoCode = 12;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.D};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00417032055114");
		assertFalse(dvIsValid);
	}
	
	@Test
	public void testDVYisValidwithInvalidSPSample() {
		Integer posicaoDoDv = 14;
		int pesoCode = 13;
		Integer fator = 0;
		Integer mod = 11;
		RotinaCode[] rotinas = {RotinaCode.D};
		CalculoDVInfo calculoDVInfo = new CalculoDVInfo(fator,rotinas ,mod,pesoCode,posicaoDoDv);
		boolean dvIsValid = calculoDVInfo.DVisValid("00417032057117");
		assertFalse(dvIsValid);
	}
	
	

}
