
package com.credera.talk.thymeleaf.processor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;

import com.credera.talk.thymeleaf.domain.Money;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

@Component("priceProcessor")
public class PriceProcessor extends AbstractTextChildModifierAttrProcessor {

    public static final int ATTR_PRECEDENCE = 1500;
    public static final String ATTR_NAME = "price";

    public PriceProcessor() {
        super(ATTR_NAME);
    }

    @Override
    public int getPrecedence() {
        return ATTR_PRECEDENCE;
    }

    @Override
    protected String getText(final Arguments arguments, final Element element, final String attributeName) {
        final String attributeValue = element.getAttributeValue(attributeName);
        Money price = null;
        Object result = StandardExpressionProcessor.processExpression(arguments, attributeValue);
        if (result instanceof Money) {
            price = (Money) result;
        } else if (result instanceof BigDecimal) {
            price = new Money((BigDecimal) result);
        } else if (result == null) {
            price = Money.ZERO;
        } else {
            throw new IllegalArgumentException("Input is not of type Money or BigDecimal");
        }
        HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Locale curLocale = (Locale) WebUtils.getSessionAttribute(curRequest, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        curLocale = (curLocale == null) ? Locale.US : curLocale;
        NumberFormat format = NumberFormat.getCurrencyInstance(curLocale);
        format.setCurrency(price.getCurrency());
        return format.format(price.getAmount());
    }
}
