package br.com.caelum.stella.hibernate.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

public class RegisterAction implements Register {
	@In
	private Modelo modelo;

	@PersistenceContext                                                                   
	   private EntityManager em;
	   
	   @Logger                                                                               
	   private Log log;
	   
	   public String register()                                                              
	   {
	      List existing = em.createQuery(
	         "select cpf from Modelo where cpf=#{modelo.cpf}")                    
	         .getResultList();
	         
	      if (existing.size()==0)
	      {
	         em.persist(modelo);
	         log.info("Registered new modelo CPF:#{modelo.cpf} CNPJ:#{modelo.cnpj}");                               
	         return "/registered.xhtml";                                                    
	      }
	      else
	      {
	         FacesMessages.instance().add("Modelo CPF:#{modelo.cpf} already exists",new Object[] {modelo});           
	         return null;
	      }
	   }

}
