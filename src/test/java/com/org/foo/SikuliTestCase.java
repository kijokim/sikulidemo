package com.org.foo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sikuli.script.App;
import org.springframework.beans.factory.annotation.Value;

public class SikuliTestCase extends POSTestSupport {
	@Value("${key1}")
	String key1;

	@Value("${key2}")
	String key2;

	@Value("${key3}")
	String key3;

	@Value("${key4}")
	String key4;

	@Value("${key5}")
	String key5;
	

	App app;
	
	@Before
	public void setup() {
		app = new App("C:\\Program Files (x86)\\YG-POS\\YG_POS.exe");
	}

	@After
	public void after() {
		app.close();
	}
}
