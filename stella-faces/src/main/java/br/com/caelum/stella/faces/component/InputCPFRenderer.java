package br.com.caelum.stella.faces.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;


@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = "br.com.caelum.stella.faces.component.InputCPFRenderer")
@ResourceDependencies({
	@ResourceDependency(library="jquery",name="jquery.js"),
	@ResourceDependency(library="mask",name="mask.js")
})
public class InputCPFRenderer extends Renderer {
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		
		InputCPF input = (InputCPF) component; 

		Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();

		String cpfValue = requestMap.get(input.getClientId(context));
		
		if(cpfValue != null){
			input.setSubmittedValue(cpfValue);
		}

	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		InputCPF input = (InputCPF) component;

		encodeMarkup(context, input);
		encodeScript(context, input);

	}

	private void encodeScript(FacesContext context, InputCPF input) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		String clientId = input.getClientId(context);
		
		writer.startElement("script", null);
		writer.writeAttribute("type", "text/javascript", null);
		
		writer.write("jQuery(function($){");
		
        writer.write("$(Stella.escapeJQueryId('" + clientId + "')).mask('" + input.getMask() + "',{placeholder:'"+input.getPlaceHolder()+"'});");

        writer.write("});");
        
		writer.endElement("script");

		
	}

	private void encodeMarkup(FacesContext context, InputCPF input)
			throws IOException {
		
		String clientId = input.getClientId(context);
        String defaultClass = InputCPF.DEFAULT_CLASS;
        String styleClass = input.getStyleClass();
        styleClass = styleClass == null ? defaultClass : defaultClass + " " + styleClass;

		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("input", input);
		writer.writeAttribute("id", clientId, null);
		writer.writeAttribute("name", clientId, null);
		writer.writeAttribute("type", "text", null);
		writer.writeAttribute("size", "14", null);
		
		Object value = input.getSubmittedValue() != null ? input.getSubmittedValue() : input.getValue();
		
		if (value != null) {
			writer.writeAttribute("value", value.toString(), "value");
		}

        if(input.isDisabled()) writer.writeAttribute("disabled", "disabled", "disabled");
        if(input.isReadonly()) writer.writeAttribute("readonly", "readonly", "readonly");
        if(input.getStyle() != null) writer.writeAttribute("style", input.getStyle(), "style");
		
        writer.writeAttribute("class", styleClass, "styleClass");

		writer.endElement("input");
	}
}
