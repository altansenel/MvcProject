package com.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.RequiredValidator;

public class SkipRequiredValidator extends RequiredValidator {

	@Override
	public void validate(final FacesContext context,
			final UIComponent component, final Object value) {
		if (ValidatorUtil.check(context)) {
			super.validate(context, component, value);
		}
	}

}