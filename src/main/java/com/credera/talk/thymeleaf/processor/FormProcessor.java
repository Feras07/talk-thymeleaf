
package com.credera.talk.thymeleaf.processor;

import org.springframework.stereotype.Component;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

import java.util.UUID;

@Component("formProcessor")
public class FormProcessor extends AbstractElementProcessor {

    public FormProcessor() {
        super("form");
    }

    @Override
    public int getPrecedence() {
        return 1;
    }

    @Override
    protected ProcessorResult processElement(Arguments arguments, Element element) {
        if ("POST".equalsIgnoreCase(element.getAttributeValueFromNormalizedName("method"))) {
            String csrfToken = UUID.randomUUID().toString();
            Element csrfNode = new Element("input");
            csrfNode.setAttribute("type", "hidden");
            csrfNode.setAttribute("name", "CSRF-Token");
            csrfNode.setAttribute("value", csrfToken);
            element.addChild(csrfNode);
        }
        return ProcessorResult.OK;
    }
}
