package com.org.foo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sikuli.script.App;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.org.foo.config.SikuliConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SikuliConfig.class, loader=AnnotationConfigContextLoader.class)
public class SikuliResourceChangeTest {

	@Autowired
	Pattern p;
	
	@Autowired
	private Environment env;

	
	@Before
	public void setup() {
	}

	@Test
	public void testPOS() {
		App app =new App("C:\\Program Files (x86)\\YG-POS\\YG_POS.exe");
		try {
			app.open();
			Thread.sleep(1000);
			Screen screen = new Screen();
			screen.click(p.setFilename(env.getProperty("key1")));
			screen.click(p.setFilename(env.getProperty("key2")));
			Thread.sleep(1000);
			screen.type(p.setFilename(env.getProperty("key3")),"1111");
			screen.click(p.setFilename(env.getProperty("key4")));
			screen.find(p.setFilename(env.getProperty("key5")));


		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
			app.close();
		}

	}


}
