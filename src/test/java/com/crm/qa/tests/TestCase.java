package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase extends TestBase {

    public TestCase() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        System.out.println("Let the Browser Start");
    }

    @Test
    public void test() {
        System.out.println("This is Browser " +System.getProperty("user.dir"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
