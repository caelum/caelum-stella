package br.com.caelum.stella.validation.ie;

import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.type.Estado;
import br.com.caelum.stella.validation.Validator;

/**
 * @author Leonardo Bessa
 */
public class IEValidator implements Validator<String> {

    private Validator<String> validator;

    public void assertValid(String object) {
        validator.assertValid(object);
    }

    public List<ValidationMessage> invalidMessagesFor(String object) {
        return validator.invalidMessagesFor(object);
    }

    public IEValidator(Estado estado, MessageProducer messageProducer,
            boolean isFormatted) {
        switch (estado) {
        case AC:
            this.validator = new IEAcreValidator(messageProducer, isFormatted);
            break;
        case AL:
            this.validator = new IEAlagoasValidator(messageProducer,
                    isFormatted);
            break;
        case AP:
            this.validator = new IEAmapaValidator(messageProducer, isFormatted);
            break;
        case AM:
            this.validator = new IEAmazonasValidator(messageProducer,
                    isFormatted);
            break;
        case BA:
            this.validator = new IEBahiaValidator(messageProducer, isFormatted);
            break;
        case CE:
            this.validator = new IECearaValidator(messageProducer, isFormatted);
            break;
        case DF:
            this.validator = new IEDistritoFederalValidator(messageProducer,
                    isFormatted);
            break;
        case ES:
            this.validator = new IEEspiritoSantoValidator(messageProducer,
                    isFormatted);
            break;
        case GO:
            this.validator = new IEGoiasValidator(messageProducer, isFormatted);
            break;
        case MA:
            this.validator = new IEMaranhaoValidator(messageProducer,
                    isFormatted);
            break;
        case MT:
            this.validator = new IEMatoGrossoValidator(messageProducer,
                    isFormatted);
            break;
        case MS:
            this.validator = new IEMatoGrossoDoSulValidator(messageProducer,
                    isFormatted);
            break;
        case MG:
            this.validator = new IEMinasGeraisValidator(messageProducer,
                    isFormatted);
            break;
        case PA:
            this.validator = new IEParaValidator(messageProducer, isFormatted);
            break;
        case PB:
            this.validator = new IEParaibaValidator(messageProducer,
                    isFormatted);
            break;
        case PR:
            this.validator = new IEParanaValidator(messageProducer, isFormatted);
            break;
        case PE:
            this.validator = new IEPernambucoValidator(messageProducer,
                    isFormatted);
            break;
        case PI:
            this.validator = new IEPiauiValidator(messageProducer, isFormatted);
            break;
        case RJ:
            this.validator = new IERioDeJaneiroValidator(messageProducer,
                    isFormatted);
            break;
        case RN:
            this.validator = new IERioGrandeDoNorteValidator(messageProducer,
                    isFormatted);
            break;
        case RS:
            this.validator = new IERioGrandeDoSulValidator(messageProducer,
                    isFormatted);
            break;
        case RO:
            this.validator = new IERondoniaValidator(messageProducer,
                    isFormatted);
            break;
        case RR:
            this.validator = new IERoraimaValidator(messageProducer,
                    isFormatted);
            break;
        case SC:
            this.validator = new IESantaCatarinaValidator(messageProducer,
                    isFormatted);
            break;
        case SP:
            this.validator = new IESaoPauloValidator(messageProducer,
                    isFormatted);
            break;
        case SE:
            this.validator = new IETocantinsValidator(messageProducer,
                    isFormatted);
            break;
        case TO:
            this.validator = new IEAcreValidator(messageProducer, isFormatted);
            break;
        }
    }

}
