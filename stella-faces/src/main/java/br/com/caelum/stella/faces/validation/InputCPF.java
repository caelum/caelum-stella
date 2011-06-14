package br.com.caelum.stella.faces.validation;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent("br.com.caelum.stella.faces.validation.InputCPF")
public class InputCPF extends UIInput {

	public InputCPF() {
		setRendererType(null);
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {

		String clientId = getClientId(context);
		encodeInputField(context, clientId + "_" + "inputfield");
		encodeSubmitButton(context, clientId + "_" + "submit");
		encodeOutputField(context);
	}

	private void encodeOutputField(FacesContext context) throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		String message = (String) getAttributes().get("value");

		writer.startElement("p", this);
		writer.writeText("message : " + message, null);
		writer.endElement("p");

	}

	private void encodeSubmitButton(FacesContext context, String clientId)
			throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("input", this);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId, "clientId");
		writer.writeAttribute("value", "Click me!", null);
		writer.endElement("input");

	}

	private void encodeInputField(FacesContext context, String clientId)
			throws IOException {

		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("input", this);
		writer.writeAttribute("type", "text", null);
		writer.writeAttribute("name", clientId, "clientId");
		Object value = getValue();
		if (value != null) {
			writer.writeAttribute("value", value.toString(), "value");
		}

		writer.writeAttribute("size", "6", null);
		writer.endElement("input");
	}

	@Override
	public void decode(FacesContext context) {

		Map<String, String> requestMap = context.getExternalContext()
				.getRequestParameterMap();
		String clientId = getClientId(context);
		String submitedHelloMsg = requestMap.get(clientId + "_" + "inputfield");
		setSubmittedValue(submitedHelloMsg);
	}

}
