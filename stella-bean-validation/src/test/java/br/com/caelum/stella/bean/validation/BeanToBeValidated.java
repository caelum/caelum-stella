package br.com.caelum.stella.bean.validation;

/**
 * @author Fabio Kung
 */
class BeanToBeValidated {

    @SuppressWarnings("unused")
    @FakeConstraint
    private String field;

    @SuppressWarnings("unused")
    @ConstraintWithoutMessage
    private String other;

}
