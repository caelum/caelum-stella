package br.com.caelum.stella.hibernate.validator;

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
