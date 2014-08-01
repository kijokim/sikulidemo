package com.org.foo;

import org.junit.Assert;
import org.junit.Test;


public class SikuliResourceChangeTest extends SikuliTestCase {

	@Test
	public void testPOS() {
		// comment
		try {
			app.open();
			screen.click(key1);
			screen.click(key2);
			screen.type(key3, "1111");
			screen.click(key4);
			screen.find(key5);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		} 
	}
}
