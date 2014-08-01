package com.org.foo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.foo.annotation.EnablePOSConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@EnablePOSConfig
public class POSTestSupport extends Assert {

	@Autowired
	Screen screen;

	@Autowired
	private Environment env;

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
