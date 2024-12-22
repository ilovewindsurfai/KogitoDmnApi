package com.example.kogitodmnapi.config;

import fitnesse.junit.FitNesseRunner;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

@ContextConfiguration(classes = {KogitoDmnApiApplication.class})
public class SpringFitNesseRunner extends FitNesseRunner {
    private final TestContextManager testContextManager;

    public SpringFitNesseRunner(Class<?> suiteClass) throws InitializationError {
        super(suiteClass);
        try {
            this.testContextManager = new TestContextManager(getTestClass().getJavaClass());
        } catch (Exception e) {
            throw new InitializationError(e);
        }
    }

    @Override
    protected Object createTestObject(Class<?> testClass) throws Exception {
        Object testObject = super.createTestObject(testClass);
        testContextManager.prepareTestInstance(testObject);
        return testObject;
    }
}

