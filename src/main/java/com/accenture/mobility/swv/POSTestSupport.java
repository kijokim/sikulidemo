package com.accenture.mobility.swv;

import com.accenture.mobility.swv.annotation.EnableSWVConfig;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@EnableSWVConfig
public class POSTestSupport extends AbstractTestNGSpringContextTests {

	@Autowired
	public Screen screen;

	@Autowired
	public Environment env;

	public App app;

	@BeforeTest
	public void setup() {

        try {
            System.err.println("###############"+env.getProperty("pos.program.path"));
            app = new App(env.getProperty("pos.program.path"));

        }catch (Exception e){
            e.printStackTrace();

        }

	}

	@AfterTest
	public void after() {
		app.close();
	}

}
