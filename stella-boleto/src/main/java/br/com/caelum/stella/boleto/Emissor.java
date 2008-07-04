package br.com.caelum.stella.boleto;

/**
 * Bean que representa os dados do emissor de um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * 
 */
public class Emissor {
    private int agencia;
    private String dvAgencia;
    private int contaCorrente;
    private int carteira;
    private String numConvenio;
    private String nossoNumero;
    private String cedente;
    private String dvContaCorrete;

    private Emissor() {
    }

    /**
     * Cria novo emissor
     * 
     * @return
     */
    public static Emissor newEmissor() {
	return new Emissor();
    }

    /**
     * Devolve o número da agencia sem o digito
     * 
     */
    public int getAgencia() {
	return agencia;
    }

    /**
     * Associa uma agencia, SEM o dígito verificador, ao emissor
     * 
     * @param agencia
     */
    public Emissor withAgencia(int agencia) {
	this.agencia = agencia;
	return this;
    }

    /**
     * Devolve o número da conta corrente sem o digito
     * 
     */
    public int getContaCorrente() {
	return contaCorrente;
    }

    /**
     * Associa uma conta corrente, SEM o dígito verificador, ao emissor
     * 
     * @param contaCorrente
     */
    public Emissor withContaCorrente(int contaCorrente) {
	this.contaCorrente = contaCorrente;
	return this;
    }

    /**
     * Devolve a carteira<br/> Valor informado pelo banco para identificação do
     * tipo de boleto
     * 
     */
    public int getCarteira() {
	return carteira;
    }

    /**
     * Associa uma carteira ao emissor<br/> Valor informado pelo banco para
     * identificação do tipo de boleto
     * 
     * @param carteira
     */
    public Emissor withCarteira(int carteira) {
	this.carteira = carteira;
	return this;
    }

    /**
     * Devolve o número do convênio<br/> Valor que identifica um emissor junto
     * ao seu banco para associar seus boletos<br/> Valor informado pelo banco
     * 
     */
    public String getNumConvenio() {
	return numConvenio;
    }

    /**
     * Associa um número de convênio ao emissor<br/> Valor que identifica um
     * emissor junto ao seu banco para associar seus boletos<br/> Valor
     * informado pelo banco
     * 
     * @param numConvenio
     */
    public Emissor withNumConvenio(String numConvenio) {
	this.numConvenio = numConvenio;
	return this;
    }

    /**
     * Devolve o nosso número<br/> Valor que o cedente escolhe para manter
     * controle sobre seus boletos. Esse valor serve para o cedente identificar
     * quais boletos foram pagos ou não. Recomenda-se o uso de números
     * sequenciais, na geração de diversos boletos, para facilitar a
     * identificação dos boletos pagos
     * 
     */
    public String getNossoNumero() {
	return nossoNumero;
    }

    /**
     * Associa o nosso número ao emissor<br/> Valor que o cedente escolhe para
     * manter controle sobre seus boletos. Esse valor serve para o cedente
     * identificar quais boletos foram pagos ou não. Recomenda-se o uso de
     * números sequenciais, na geração de diversos boletos, para facilitar a
     * identificação dos boletos pagos
     * 
     * @param nossoNumero
     */
    public Emissor withNossoNumero(String nossoNumero) {
	this.nossoNumero = nossoNumero;
	return this;
    }

    /**
     * Devolve o cedente. (nome do emissor)
     * 
     */
    public String getCedente() {
	return cedente;
    }

    /**
     * Associa um cedente (nome) ao emissor
     * 
     * @param cedente
     */
    public Emissor withCedente(String cedente) {
	this.cedente = cedente;
	return this;
    }

    /**
     * Devolve o digito verificador (DV) da conta corrente
     * 
     * @return
     */
    public String getDvContaCorrente() {
	return dvContaCorrete;
    }

    /**
     * Associa um digito verificador (DV) da conta corrente ao emissor
     * 
     * @param dv
     * @return
     */
    public Emissor withDvContaCorrete(String dv) {
	dvContaCorrete = dv;
	return this;
    }

    /**
     * Devolve o digito verificador (DV) da agencia
     * 
     * @return
     */
    public String getDvAgencia() {
	return dvAgencia;
    }

    /**
     * Associa um digito verificador (DV) da agencia ao emissor
     * 
     * @param dv
     * @return
     */
    public Emissor withDvAgencia(String dv) {
	dvAgencia = dv;
	return this;
    }

    /**
     * Devolve a conta corrente formatada (com 7 digitos)
     * 
     * @return
     */
    public String getContaCorrenteFormatado() {
	return String.format("%07d", contaCorrente);
    }

    /**
     * Devolve a agencia formatada (com 4 digitos)
     * 
     * @return
     */
    public String getAgenciaFormatado() {
	return String.format("%04d", agencia);
    }

    /**
     * Devolve a carteira formatada (com 2 digitos)
     * 
     * @return
     */
    public String getCarteiraFormatado() {
	return String.format("%02d", carteira);
    }

    /**
     * Devolve o nosso número formatado (com 10 digitos)
     * 
     * @return
     */
    public String getNossoNumeroFormatado() {
	return String.format("%010d", Integer.parseInt(nossoNumero));
    }

    /**
     * Devolve o número do convênio formatado (com 7 digitos)
     * 
     * @return
     */
    public String getNumConvenioFormatado() {
	return String.format("%07d", Integer.parseInt(numConvenio));
    }
}
