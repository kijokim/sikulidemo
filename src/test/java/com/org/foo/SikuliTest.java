package com.org.foo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.sikuli.script.App;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class SikuliTest {

	@Before
	public void setup() {
	}

	@Test
	@Ignore("bypass")
	public void testPOS() {
		App app =new App("C:\\Program Files (x86)\\YG-POS\\YG_POS.exe");
		try {
			app.open();
			Screen screen = new Screen();
			screen.click(new Pattern("src\\main\\resources\\device1\\1.png"));
			screen.click(new Pattern("src\\main\\resources\\device1\\2.png"));
			screen.type(new Pattern("src\\main\\resources\\device1\\3.png"), "11112222");
			screen.click(new Pattern("src\\main\\resources\\device1\\4.png"));
			screen.find(new Pattern("src\\main\\resources\\device1\\5.png"));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}finally {
			app.close();
		}

	}


}
