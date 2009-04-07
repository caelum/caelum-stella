package br.com.caelum.stella.gateway;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.bb.TipoTransacao;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;

public class TestDescobreEnumPeloCodigo {

	@Test
	public void testDescobrirEnumPeloCodigo(){
		Assert.assertEquals(TipoTransacao.TODAS_MODALIDADES,new EnumComCodigoFinder().descobreAEnumPeloCodigo(TipoTransacao.class,"0"));
	}
}
