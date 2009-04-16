package br.com.caelum.stella.gateway;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.bb.BBTipoTransacao;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;

public class TestDescobreEnumPeloCodigo {

	@Test
	public void testDescobrirEnumPeloCodigo(){
		Assert.assertEquals(BBTipoTransacao.TODAS_MODALIDADES,new EnumComCodigoFinder().descobreAEnumPeloCodigo(BBTipoTransacao.class,"0"));
	}
}
