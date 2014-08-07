package com.accenture.mobility.swv;

import com.accenture.mobility.swv.annotation.EnableSWVConfig;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;

@EnableSWVConfig
public class POSTestSupport extends AbstractTestNGSpringContextTests {

    @Autowired
    public Screen screen;

    @Autowired
    public Environment env;

    @Autowired
    public App app;


    @AfterTest
    public void after() {
        app.close();
    }

}
