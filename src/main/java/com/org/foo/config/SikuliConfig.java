package com.org.foo.config;

import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.org.foo.sikuli.CustomScreen;

@Configuration
@PropertySource(value = { "default.properties",
		"classpath:${spring.profiles.active}.properties" }, ignoreResourceNotFound = true)
public class SikuliConfig implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SikuliConfig.class);
	@Autowired
	private Environment env;

	@Autowired
	private ApplicationContext context;

	private String targetDevice;

	public String getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Screen customScreen() {
		return new CustomScreen("src/main/resources/" + getTargetDevice()
				+ "/");
	}
	
	public void afterPropertiesSet() throws Exception {
		if (env.getActiveProfiles().length == 0) {
			throw new Exception("avtive Profile does not exist!!!");
		} else {
			setTargetDevice(env.getActiveProfiles()[0]);
		}
		System.out.println("target deivce [" + getTargetDevice()
				+ "] is selected!");

	}
}
