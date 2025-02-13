package br.com.caelum.stella.type;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.ie.IEAcreValidator;
import br.com.caelum.stella.validation.ie.IEAlagoasValidator;
import br.com.caelum.stella.validation.ie.IEAmapaValidator;
import br.com.caelum.stella.validation.ie.IEAmazonasValidator;
import br.com.caelum.stella.validation.ie.IEBahiaValidator;
import br.com.caelum.stella.validation.ie.IECearaValidator;
import br.com.caelum.stella.validation.ie.IEDistritoFederalValidator;
import br.com.caelum.stella.validation.ie.IEEspiritoSantoValidator;
import br.com.caelum.stella.validation.ie.IEGoiasValidator;
import br.com.caelum.stella.validation.ie.IEMaranhaoValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoDoSulValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoValidator;
import br.com.caelum.stella.validation.ie.IEMinasGeraisValidator;
import br.com.caelum.stella.validation.ie.IEParaValidator;
import br.com.caelum.stella.validation.ie.IEParaibaValidator;
import br.com.caelum.stella.validation.ie.IEParanaValidator;
import br.com.caelum.stella.validation.ie.IEPernambucoValidator;
import br.com.caelum.stella.validation.ie.IEPiauiValidator;
import br.com.caelum.stella.validation.ie.IERioDeJaneiroValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoNorteValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoSulValidator;
import br.com.caelum.stella.validation.ie.IERondoniaValidator;
import br.com.caelum.stella.validation.ie.IERoraimaValidator;
import br.com.caelum.stella.validation.ie.IESantaCatarinaValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import br.com.caelum.stella.validation.ie.IESergipeValidator;
import br.com.caelum.stella.validation.ie.IETocantinsValidator;

/**
 * Respresenta um estado brasileiro, ou o Destrito Federal.
 * 
 * @author leobessa
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public enum Estado {

    AC(12, "24") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAcreValidator(messageProducer, isFormatted);
        }
        
    },
    AL(27, "17") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAlagoasValidator(messageProducer, isFormatted);
        }

    },
    AP(16, "25") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmapaValidator(messageProducer, isFormatted);
        }

    },
    AM(13, "22") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmazonasValidator(messageProducer, isFormatted);
        }

    },
    BA(29, "05") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEBahiaValidator(messageProducer, isFormatted);
        }

    },
    CE(23, "07") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IECearaValidator(messageProducer, isFormatted);
        }

    },
    DF(53, "20") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEDistritoFederalValidator(messageProducer, isFormatted);
        }

    },
    ES(32, "14") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEEspiritoSantoValidator(messageProducer, isFormatted);
        }

    },
    GO(52, "10") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEGoiasValidator(messageProducer, isFormatted);
        }

    },
    MA(21, "11") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMaranhaoValidator(messageProducer, isFormatted);
        }

    },
    MT(51, "18") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoValidator(messageProducer, isFormatted);
        }

    },
    MS(50, "19") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoDoSulValidator(messageProducer, isFormatted);
        }

    },
    MG(31, "02") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMinasGeraisValidator(messageProducer, isFormatted);
        }

    },
    PA(15, "13") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaValidator(messageProducer, isFormatted);
        }

    },
    PB(25, "12") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaibaValidator(messageProducer, isFormatted);
        }

    },
    PR(41, "06") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParanaValidator(messageProducer, isFormatted);
        }

    },
    PE(26, "08") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPernambucoValidator(messageProducer, isFormatted);
        }

    },
    PI(22, "15") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPiauiValidator(messageProducer, isFormatted);
        }

    },
    RJ(33, "03") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioDeJaneiroValidator(messageProducer, isFormatted);
        }

    },
    RN(24, "16") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoNorteValidator(messageProducer, isFormatted);
        }

    },
    RS(43, "04") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoSulValidator(messageProducer, isFormatted);
        }

    },
    RO(11, "23") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERondoniaValidator(messageProducer, isFormatted);
        }

    },
    RR(14, "26") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERoraimaValidator(messageProducer, isFormatted);
        }

    },
    SC(42, "09") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESantaCatarinaValidator(messageProducer, isFormatted);
        }

    },
    SP(35, "01") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESaoPauloValidator(messageProducer, isFormatted);
        }

    },
    SE(28, "21") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESergipeValidator(messageProducer, isFormatted);
        }

    },
    TO(17, "27") {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IETocantinsValidator(messageProducer, isFormatted);
        }

    };

    private final int codigoIBGE;
    
    private final String codigoEleitoral;

	/**
     * Retorna um validador de Inscrição Estadual.
     * 
     * @param messageProducer
     *            um produtor de mensagens.
     * @param isFormatted
     *            indicando se o validador deve considerar as cadeias como
     *            formatadas.
     * @return Validador de Inscrição Estudual correspondente.
     */
    public abstract Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted);
    
    private Estado(int codigoIBGE, String codigoEleitoral) {
    	this.codigoIBGE = codigoIBGE;
    	this.codigoEleitoral = codigoEleitoral;
	}
    
    public int getCodigoIBGE() {
		return codigoIBGE;
	}
    
    public String getCodigoEleitoral() {
		return codigoEleitoral;
	}

	/**
	 * A região do território brasileiro em que esse estado está localizado.
	 *
	 * @return Retorna a região em que esse estado está localizado.
	 */
	public Regiao regiao() {
		Regiao[] regioes = Regiao.values();

		for (Regiao regiao : regioes) {
			if(regiao.compostaPor(this)) {
				return regiao;
			}
		}

		throw new IllegalStateException("Não foi possível determinar a região do estado " + this);
	}

	/**
	 * Verifica se esse estado está localizado na região informada.
	 *
	 * @param regiao Uma das regiões do território brasileiro.
	 * @return Retorna {@code true} se esse estado pertencer à região informada ou {@code false} caso contrário.
	 */
	public boolean localizadoEm(Regiao regiao) {
		return regiao() == regiao;
	}
	
	public static Estado deCodigoEleitoral(String codigo) {
		
		Estado[] estados = Estado.values();
		
		for (Estado estado : estados) {
			if (estado.getCodigoEleitoral().equals(codigo)) {
				return estado;
			}
		}
		
		throw new IllegalStateException("Não foi possível determinar o estado a partir do código eleitoral " + codigo);
	}
}
