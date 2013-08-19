
package com.credera.talk.thymeleaf.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.testing.templateengine.context.web.SpringWebProcessingContextBuilder;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-servlet.xml" })
public class ViewTest {

    @Resource(name = "templateEngine")
    private TemplateEngine templateEngine;

    @Test
    public void testThymeleafTemplates() {
    	final SpringWebProcessingContextBuilder springPCBuilder = new SpringWebProcessingContextBuilder();
    	springPCBuilder.setApplicationContextConfigLocation("classpath:applicationContext-servlet.xml");
        final TestExecutor executor = new TestExecutor();
        executor.setDialects(new ArrayList<IDialect>(templateEngine.getDialects()));
        executor.execute("classpath:template");
        Assert.assertTrue(executor.getReporter().isAllOK());
    }
}
