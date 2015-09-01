package br.com.caelum.stella.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

public class LogicOrComposedValidator<T> implements Validator<T> {

    public Validator<T>[] validators;

    public MessageProducer messageProducer;

    public InvalidValue invalidFormat = new InvalidValue() {

        public String name() {
            return "INVALID_FORMAT";
        }
    };

    @SuppressWarnings("unchecked")
    public LogicOrComposedValidator(MessageProducer messageProducer, boolean isFormatted,
            Class<? extends Validator<T>>... validatorClasses) {
        if (validatorClasses.length == 0) {
            throw new IllegalArgumentException(
                    "Ao menos um validador deve ser passado como argumento na construção");
        }
        this.messageProducer = messageProducer;
        this.validators = new Validator[validatorClasses.length];
        int i = 0;
        for (Class<? extends Validator<T>> clazz : validatorClasses) {
            Constructor<? extends Validator<T>> constructor;
            try {
                constructor = clazz.getConstructor(MessageProducer.class, boolean.class);
                constructor.setAccessible(true);
                validators[i++] = constructor.newInstance(messageProducer, isFormatted);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void assertValid(T value) {
        InvalidStateException lastException = null;
        boolean isValid = false;
        for (Validator<T> v : validators) {
            if (v.isEligible(value)) {
                try {
                    v.assertValid(value);
                    isValid = true;
                    break;
                } catch (InvalidStateException e) {
                    lastException = e;
                }
            }
        }
        if (!isValid) {
            if (lastException != null) {
                throw lastException;
            } else {
                throw new InvalidStateException(messageProducer.getMessage(invalidFormat));
            }
        }
    }

    public List<ValidationMessage> invalidMessagesFor(T value) {
        List<ValidationMessage> result = null;
        for (Validator<T> v : validators) {
            if (v.isEligible(value)) {
                List<ValidationMessage> invalidMessages = v.invalidMessagesFor(value);
                result = invalidMessages;
                if (invalidMessages.isEmpty()) {
                    break;
                }
            }
        }
        if (result == null) {
            result = new ArrayList<ValidationMessage>();
            result.add(messageProducer.getMessage(invalidFormat));
        }
        return result;
    }

    public boolean isEligible(T object) {
        boolean result = false;
        for (Validator<T> v : validators) {
            if (v.isEligible(object)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void setInvalidFormat(InvalidValue invalidFormat) {
        this.invalidFormat = invalidFormat;
    }

    /**
     * @see Validator#generateRandomValid()
	 * @return um documento válido de acordo com as regras do primeiro validador passado como
	 *         argumento na construção deste validador
	 */
    @Override
    public T generateRandomValid() {
        return validators[0].generateRandomValid();
    }
}
