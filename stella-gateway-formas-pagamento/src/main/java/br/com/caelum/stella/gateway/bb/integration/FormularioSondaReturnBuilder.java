package br.com.caelum.stella.gateway.bb.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.gateway.bb.Situacao;
import br.com.caelum.stella.gateway.bb.TipoTransacao;
import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.CalendarFormatter;
import br.com.caelum.stella.gateway.core.IntegrationFailedException;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;
import br.com.caelum.stella.gateway.core.ReturnBuilder;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;

public enum FormularioSondaReturnBuilder implements
		ReturnBuilder<BBFormularioSondaReturn,String> {

	HTML("01"){

		public BBFormularioSondaReturn buildRetorno(String source) {
			// TODO Auto-generated method stub
			throw new IntegrationFailedException("Essa forma ainda não esta implementada");
		}


		
	},
	
	XML("02"){

		public BBFormularioSondaReturn buildRetorno(String source) {
			// TODO Auto-generated method stub
			return null;
		}


		
	},
	
	STRING("03"){

		public BBFormularioSondaReturn buildRetorno(String source) {
			// TODO Auto-generated method stub
			String refTran = source.substring(0,18);
			BigDecimal valor = BigDecimalFormatter.stringInCentsToBigDecimal(source.substring(17,33));
			String idConv = source.substring(32,39);			
			TipoTransacao tipoTransacao = new EnumComCodigoFinder<TipoTransacao>().descobreAEnumPeloCodigo(TipoTransacao.class,source.substring(38,40));
			Situacao situacao = new EnumComCodigoFinder<Situacao>().descobreAEnumPeloCodigo(Situacao.class,source.substring(39,42));
			Calendar dataPagamento = CalendarFormatter.stringToCalendar(source.substring(41));
			return null;
		}


		
	};
	
	private String codigo;
	
	private FormularioSondaReturnBuilder(String codigo){
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigo;
	}

	
	
}
