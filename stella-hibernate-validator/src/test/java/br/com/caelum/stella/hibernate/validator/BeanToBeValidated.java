package br.com.caelum.stella.hibernate.validator;

/**
 * @Author Fabio Kung
 */
class BeanToBeValidated {

    @SuppressWarnings("unused")
	@FakeConstraint
    private String field;

    @SuppressWarnings("unused")
	@ConstraintWithoutMessage
    private String other;

}
