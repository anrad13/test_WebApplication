package com.anrad.record;

import java.text.MessageFormat;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("recordNameValidator")
public class RecordNameValidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String name = (String) value;
        
        if (name.length() > 1) return;
        
        String message = MessageFormat.format("{0} have to be more that 1 char", name);
        FacesMessage facesMessage =
            new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        throw new ValidatorException(facesMessage);
    }
    
    
}
