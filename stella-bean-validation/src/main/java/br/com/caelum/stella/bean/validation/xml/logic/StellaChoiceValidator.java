package br.com.caelum.stella.bean.validation.xml.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.stella.bean.validation.xml.Choice;
import br.com.caelum.stella.bean.validation.xml.ChoiceItem;

public class StellaChoiceValidator implements ConstraintValidator<Choice, Object> {

    public void initialize(final Choice annotation) {
    }

    public boolean isValid(final Object toValidate, ConstraintValidatorContext context) {
        Class<? extends Object> type = toValidate.getClass();
        if (!hasChoiceItens(toValidate)) {
            return validateChoice(toValidate, new Mirror().on(type).reflectAll().fields());
        }
        return validateChoice(toValidate, getChoiceItemAnnotatedFields(type));
    }

    private List<Field> getChoiceItemAnnotatedFields(final Class<? extends Object> type) {
        List<Field> result = new ArrayList<Field>();
        for (Field field : new Mirror().on(type).reflectAll().fields()) {
            if (new Mirror().on(field).reflect().annotation(ChoiceItem.class) != null) {
                result.add(field);
            }
        }

        return result;
    }

    private boolean validateChoice(final Object toValidate, final List<Field> fields) {
        int nonNullFields = 0;
        for (Field field : fields) {
            if (!field.getClass().isPrimitive()) {
                Object object = new Mirror().on(toValidate).get().field(field);
                if (object != null) {
                    nonNullFields++;
                }
            }
        }
        return nonNullFields == 1;
    }

    private boolean hasChoiceItens(final Object toValidate) {
        for (Field f : new Mirror().on(toValidate.getClass()).reflectAll().fields()) {
            if (new Mirror().on(f).reflect().annotation(ChoiceItem.class) != null) {
                return true;
            }
        }
        return false;
    }

}
