
package com.credera.talk.thymeleaf.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.credera.talk.thymeleaf.controller.form.ProductForm;
import com.credera.talk.thymeleaf.controller.form.ProductFormValidator;
import com.credera.talk.thymeleaf.domain.Category;
import com.credera.talk.thymeleaf.domain.Money;
import com.credera.talk.thymeleaf.domain.Product;
import com.credera.talk.thymeleaf.domain.SelectOption;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/controls")
public class ControlController extends DemoController {

    @Resource
    private ProductFormValidator validator;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Category.class, "category", new PropertyEditorSupport() {

            @Override
            public String getAsText() {
                if (getValue() != null) {
                    return ((Category) getValue()).getId().toString();
                }
                return null;
            }

            @Override
            public void setAsText(String text) {
                if (!StringUtils.isEmpty(text)) {
                    setValue(catalogService.getCategoriesMap().get(Long.parseLong(text)));
                }
            }
        });
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProductList(HttpServletRequest request, Model model) {
        return "controls/controlsProductList";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewProduct(HttpServletRequest request, Model model,
            @ModelAttribute("productForm") ProductForm form, BindingResult errors, RedirectAttributes attrs) {
        return "controls/controlsProductForm";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createNewProduct(HttpServletRequest request, Model model,
            @ModelAttribute("productForm") ProductForm form, BindingResult errors, RedirectAttributes attrs) {
        validator.validate(form, errors);
        if (errors.hasErrors()) {
            return "controls/controlsProductForm";
        }
        Product product = new Product();
        product.setSku(form.getSku());
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(new Money(form.getPrice()));
        product.setCategory(form.getCategory());
        catalogService.saveProduct(product);
        attrs.addFlashAttribute("successMessage", "Successfully added Product");
        return "redirect:/controls";
    }

    @ModelAttribute("categoryOptions")
    public List<SelectOption> getCategoryOptions() {
        List<SelectOption> categoryOptions = new ArrayList<>();
        categoryOptions.add(new SelectOption("", "Select Category"));
        for (Category category : getCategories()) {
            categoryOptions.add(new SelectOption(category.getId().toString(), category.getName()));
        }
        return categoryOptions;
    }
}
