package com.acn.automation;

import com.acn.automation.annotation.EnablePOSConfig;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@EnablePOSConfig
public class POSTestSupport extends AbstractTestNGSpringContextTests {

	@Autowired
	public Screen screen;

	@Autowired
	public Environment env;

	public App app;

	@BeforeTest
	public void setup() {
		app = new App("C:\\Program Files (x86)\\YG-POS\\YG_POS.exe");
	}

	@AfterTest
	public void after() {
		app.close();
	}

}
