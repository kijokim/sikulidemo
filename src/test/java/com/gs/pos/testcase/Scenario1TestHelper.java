package com.gs.pos.testcase;

import com.acn.automation.POSTestSupport;
import org.springframework.beans.factory.annotation.Value;

public class Scenario1TestHelper extends POSTestSupport {
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
	
}
