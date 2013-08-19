
package com.credera.talk.thymeleaf.layout;

import org.springframework.web.servlet.View;
import org.thymeleaf.spring3.view.AbstractThymeleafView;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class LayoutThymeleafViewResolver extends ThymeleafViewResolver {

    protected Map<String, String> layoutMap = new HashMap<String, String>();
    protected String defaultLayout = "layout/defaultLayout";

    @Override
    protected View loadView(final String originalViewName, final Locale locale) throws Exception {
        String viewName = originalViewName;

        String longestPrefix = "";
        for (Entry<String, String> entry : layoutMap.entrySet()) {
            String viewPrefix = entry.getKey();
            String viewLayout = entry.getValue();

            if (viewPrefix.length() > longestPrefix.length()) {
                if (originalViewName.startsWith(viewPrefix)) {
                    longestPrefix = viewPrefix;

                    if (!"NONE".equals(viewLayout)) {
                        viewName = viewLayout;
                    }
                }
            }
        }

        if (longestPrefix.equals("")) {
            viewName = getDefaultLayout();
        }

        AbstractThymeleafView view = (AbstractThymeleafView) super.loadView(viewName, locale);

        view.addStaticVariable("TEMPLATENAME", originalViewName);

        return view;
    }

    public Map<String, String> getLayoutMap() {
        return layoutMap;
    }

    public void setLayoutMap(Map<String, String> layoutMap) {
        this.layoutMap = layoutMap;
    }

    public String getDefaultLayout() {
        return defaultLayout;
    }

    public void setDefaultLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
    }
}
