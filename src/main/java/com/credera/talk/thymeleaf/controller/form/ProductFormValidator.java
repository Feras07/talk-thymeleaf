
package com.credera.talk.thymeleaf.controller.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.credera.talk.thymeleaf.domain.Money;

@Component
public class ProductFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductForm.class.equals(clazz);
    }

    @Override
    public void validate(Object form, Errors errors) {
        ProductForm productForm = (ProductForm) form;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "product.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sku", "product.sku.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "product.description.required");
        if (!errors.hasFieldErrors("price")) {
            if (productForm.getPrice() == null) {
                errors.rejectValue("price", "product.price.required");
            } else if (Money.ZERO.greaterThanOrEqual(productForm.getPrice())) {
                errors.rejectValue("price", "product.price.invalid");
            }
        }

        if (productForm.getCategory() == null) {
            errors.rejectValue("category", "product.category.required");
        }

    }

}
