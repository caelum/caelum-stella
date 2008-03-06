package br.com.caelum.stella.faces.validation;

import java.io.IOException;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.TagHandler;

public class StellaCPFValidatorFaceletTag extends TagHandler {

	// possible attributes
	private final TagAttribute validatorId;
	
	
	 public StellaCPFValidatorFaceletTag(TagConfig config) {
		super(config);
		     
     // helper method for getting a required attribute
     this.validatorId = this.getRequiredAttribute("validatorId");
     
  
 }
	  /**
	   * Threadsafe Method for controlling evaluation of
	   * its child tags, represented by "nextHandler"
	   */
	  public void apply(FaceletContext ctx, UIComponent parent)
	          throws IOException, FacesException, ELException {
	      boolean b = this.validatorId.getBoolean(ctx);
	      if (this.validatorId != null) {
	          ctx.setAttribute(validatorId.getValue(ctx), new Boolean(b));
	      }
	      if (b) {
	          this.nextHandler.apply(ctx, parent);
	      }
	  }

}
