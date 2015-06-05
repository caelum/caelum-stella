package br.com.caelum.stella.validation;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.validation.AcceptAnyValidator.Documento;

/**
 * Created by IntelliJ IDEA. User: leonardobessa Date: Jan 26, 2009 Time:
 * 5:02:31 PM
 */
public class AcceptAnyValidatorTest {

    @Test
    public void testAssertValidForCpf() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CPF);
        String cpf = "336.397.038-20";
        validator.assertValid(cpf);
    }

    @Test
    public void testAssertValidForCnpj() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CNPJ);
        String cnpj = "26.637.142/0001-58";
        validator.assertValid(cnpj);
    }

    @Test
    public void testInvalidMessagesForCpf() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CPF);
        String cpf = "336.397.038-20";
        Assert.assertTrue(validator.invalidMessagesFor(cpf).isEmpty());
    }

    @Test
    public void testAssertValidForCpnj() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CNPJ);
        String cnpj = "26.637.142/0001-58";
        Assert.assertTrue(validator.invalidMessagesFor(cnpj).isEmpty());
    }

    @Test(expected = InvalidStateException.class)
    public void testAssertValidForInvalidCpf() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CPF);
        String cpf = "336.397.038-22";
        validator.assertValid(cpf);
    }

    @Test(expected = InvalidStateException.class)
    public void testAssertValidForInvalidCnpj() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CNPJ);
        String cnpj = "26.637.142/0001-57";
        validator.assertValid(cnpj);
    }

    @Test
    public void testInvalidMessagesForInvalidCpf() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CPF);
        String cpf = "336.397.038-10";
        Assert.assertFalse(validator.invalidMessagesFor(cpf).isEmpty());
    }

    @Test
    public void testAssertValidForInvalidCpnj() {
        Validator<String> validator = new AcceptAnyValidator(Documento.CNPJ);
        String cnpj = "26.637.142/0001-68";
        Assert.assertFalse(validator.invalidMessagesFor(cnpj).isEmpty());
    }

    @Test
    public void testAssertValidForUnformatedCpf() {
        Validator<String> validator = new AcceptAnyValidator(false, Documento.CPF);
        String cpf = "33639703820";
        validator.assertValid(cpf);
    }

    @Test
    public void testAssertValidForUnformatedCnpj() {
        Validator<String> validator = new AcceptAnyValidator(false, Documento.CNPJ);
        String cnpj = "26637142000158";
        validator.assertValid(cnpj);
    }

    @Test
    public void testInvalidMessagesForUnformatedCpf() {
        Validator<String> validator = new AcceptAnyValidator(false, Documento.CPF);
        String cpf = "33639703820";
        Assert.assertTrue(validator.invalidMessagesFor(cpf).isEmpty());
    }

    @Test
    public void testAssertValidForUnformatedCpnj() {
        Validator<String> validator = new AcceptAnyValidator(false, Documento.CNPJ);
        String cnpj = "26637142000158";
        Assert.assertTrue(validator.invalidMessagesFor(cnpj).isEmpty());
    }

    @Test
    public void shouldGenerateARandomValidDocumentBasedOnTheFirstDocumentPassedOnConstruction() {
        Validator<String> cpfOnlyValidator = new AcceptAnyValidator(false, Documento.CPF);
        String validCpf = cpfOnlyValidator.generateRandomValid();
        new CPFValidator(false).assertValid(validCpf);

        Validator<String> cnpjOnlyValidator = new AcceptAnyValidator(false, Documento.CNPJ);
        String validCnpj = cnpjOnlyValidator.generateRandomValid();
        new CNPJValidator(false).assertValid(validCnpj);

        Validator<String> cnpjCpfFormattedValidator = new AcceptAnyValidator(true, Documento.CNPJ, Documento.CPF);
        String anotherValidCnpj = cnpjCpfFormattedValidator.generateRandomValid();
        new CNPJValidator(true).assertValid(anotherValidCnpj);
    }
}
