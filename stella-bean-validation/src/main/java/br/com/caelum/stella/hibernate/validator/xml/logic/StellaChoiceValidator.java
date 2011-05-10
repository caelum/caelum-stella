package br.com.caelum.stella.hibernate.validator.xml.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.vidageek.mirror.Mirror;

import org.hibernate.validator.Validator;

import br.com.caelum.stella.hibernate.validator.xml.Choice;
import br.com.caelum.stella.hibernate.validator.xml.ChoiceItem;

public class StellaChoiceValidator implements Validator<Choice> {

    public void initialize(final Choice annotation) {
    }

    public boolean isValid(final Object toValidate) {
        Class<? extends Object> type = toValidate.getClass();
        if (!hasChoiceItens(toValidate)) {
            return validateChoice(toValidate, Mirror.on(type).reflectAll().fields());
        }
        return validateChoice(toValidate, getChoiceItemAnnotatedFields(type));
    }

    private List<Field> getChoiceItemAnnotatedFields(final Class<? extends Object> type) {
        List<Field> result = new ArrayList<Field>();
        for (Field field : Mirror.on(type).reflectAll().fields()) {
            if (Mirror.on(field).reflect().annotation(ChoiceItem.class) != null) {
                result.add(field);
            }
        }

        return result;
    }

    private boolean validateChoice(final Object toValidate, final List<Field> fields) {
        int nonNullFields = 0;
        for (Field field : fields) {
            if (!field.getClass().isPrimitive()) {
                Object object = Mirror.on(toValidate).get().field(field);
                if (object != null) {
                    nonNullFields++;
                }
            }
        }
        return nonNullFields == 1;
    }

    private boolean hasChoiceItens(final Object toValidate) {
        for (Field f : Mirror.on(toValidate.getClass()).reflectAll().fields()) {
            if (Mirror.on(f).reflect().annotation(ChoiceItem.class) != null) {
                return true;
            }
        }
        return false;
    }
}
