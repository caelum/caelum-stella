package br.com.caelum.stella.usertype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import br.com.caelum.stella.tinytype.CNPJ;

/**
 * @author Dayan Costa
 */
@Entity
public class PessoaJuridica {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Type(type = "br.com.caelum.stella.usertype.CnpjUserType")
  private CNPJ cnpj;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CNPJ getCnpj() {
    return cnpj;
  }

  public void setCnpj(CNPJ cnpj) {
    this.cnpj = cnpj;
  }

}
