package br.com.caelum.stella.hibernate.validator;

/**
 * @Author Fabio Kung
 */
class BeanToBeValidated {

    @FakeConstraint
    private String field;

    @ConstraintWithoutMessage
    private String other;

}
