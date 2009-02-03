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
 * 
 */
public enum Estado {

    AC {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAcreValidator(messageProducer, isFormatted);
        }

    },
    AL {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAlagoasValidator(messageProducer, isFormatted);
        }

    },
    AP {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmapaValidator(messageProducer, isFormatted);
        }

    },
    AM {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmazonasValidator(messageProducer, isFormatted);
        }

    },
    BA {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEBahiaValidator(messageProducer, isFormatted);
        }

    },
    CE {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IECearaValidator(messageProducer, isFormatted);
        }

    },
    DF {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEDistritoFederalValidator(messageProducer, isFormatted);
        }

    },
    ES {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEEspiritoSantoValidator(messageProducer, isFormatted);
        }

    },
    GO {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEGoiasValidator(messageProducer, isFormatted);
        }

    },
    MA {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMaranhaoValidator(messageProducer, isFormatted);
        }

    },
    MT {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoValidator(messageProducer, isFormatted);
        }

    },
    MS {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoDoSulValidator(messageProducer, isFormatted);
        }

    },
    MG {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMinasGeraisValidator(messageProducer, isFormatted);
        }

    },
    PA {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaValidator(messageProducer, isFormatted);
        }

    },
    PB {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaibaValidator(messageProducer, isFormatted);
        }

    },
    PR {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParanaValidator(messageProducer, isFormatted);
        }

    },
    PE {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPernambucoValidator(messageProducer, isFormatted);
        }

    },
    PI {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPiauiValidator(messageProducer, isFormatted);
        }

    },
    RJ {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioDeJaneiroValidator(messageProducer, isFormatted);
        }

    },
    RN {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoNorteValidator(messageProducer, isFormatted);
        }

    },
    RS {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoSulValidator(messageProducer, isFormatted);
        }

    },
    RO {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERondoniaValidator(messageProducer, isFormatted);
        }

    },
    RR {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERoraimaValidator(messageProducer, isFormatted);
        }

    },
    SC {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESantaCatarinaValidator(messageProducer, isFormatted);
        }

    },
    SP {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESaoPauloValidator(messageProducer, isFormatted);
        }

    },
    SE {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESergipeValidator(messageProducer, isFormatted);
        }

    },
    TO {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IETocantinsValidator(messageProducer, isFormatted);
        }

    };

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
}
