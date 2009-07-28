package br.com.caelum.stella.gateway.integration;

import javax.servlet.http.HttpServletRequest;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.visa.VISAComponentReturnHandler;
import br.com.caelum.stella.gateway.visa.VISAIntegrationReturn;

/**
 * Testa os possiveis de retorno
 * @author Alberto Pc
 *
 */
public class VISATestRetornoComponente {

	@Test
	public void testRetornoValidoDoCheckoutComLrIgualA00() {
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);		
		mockery.checking(new Expectations(){
			{				
				atLeast(1).of(request).getParameter("lr");will(returnValue("00"));								
			}
		});
		new VISAComponentReturnHandler(criarRetornoDeIntegracao(request)).check();		
		mockery.assertIsSatisfied();
	}

	@Test
	public void testRetornoValidoDoCheckoutComLrIgualA11() {
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);		
		mockery.checking(new Expectations(){
			{
				atLeast(1).of(request).getParameter("lr");will(returnValue("11"));																
			}
		});	
		new VISAComponentReturnHandler(criarRetornoDeIntegracao(request)).check();		
		mockery.assertIsSatisfied();
	}	
	
	private VISAIntegrationReturn criarRetornoDeIntegracao(final HttpServletRequest request) {
		return new VISAIntegrationReturn(){

			public String getArs() {
				// TODO Auto-generated method stub
				return "Não deve ser utilizado";
			}

			public int getLr() {
				// TODO Auto-generated method stub
				return Integer.valueOf(request.getParameter("lr"));
			}

			public String getTid() {
				// TODO Auto-generated method stub
				return "432743896";
			}
			
		};
	}
	
}
