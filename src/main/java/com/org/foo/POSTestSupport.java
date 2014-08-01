package com.org.foo;

import org.junit.runner.RunWith;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.foo.annotation.EnablePOSConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@EnablePOSConfig
public class POSTestSupport {
	
	@Autowired
	Screen screen;
	
	@Autowired
	private Environment env;
	


	
	
	

}
