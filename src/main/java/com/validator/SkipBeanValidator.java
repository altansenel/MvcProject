package com.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.BeanValidator;

public class SkipBeanValidator extends BeanValidator {

	@Override
	public void validate(final FacesContext context,
			final UIComponent component, final Object value) {
		if (ValidatorUtil.check(context)) {
			super.validate(context, component, value);
		}
	}

}
