package com.org.foo.config;

import org.sikuli.script.Pattern;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:${spring.profiles.active:device1}.properties")
public class SikuliConfig implements InitializingBean {

	@Autowired
	private Environment env;

	private String targetDevice;

	public String getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}

	@Bean
	public Pattern customPattern() {
		return new CustomPattern("src/main/resources/" + getTargetDevice()
				+ "/");
	}

	public void afterPropertiesSet() throws Exception {
		if (env.getActiveProfiles().length == 0) {
			throw new Exception("avtive Profile does not exist!!!");
		} else {
			setTargetDevice(env.getActiveProfiles()[0]);
		}
	}
}
