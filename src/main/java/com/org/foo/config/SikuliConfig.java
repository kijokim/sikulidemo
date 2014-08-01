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
@PropertySource(value = { "classpath:${target.scenario.name}/${target.scenario.name}.properties",
		"classpath:${target.scenario.name}/${spring.profiles.active}.properties" }, ignoreResourceNotFound = true)
public class SikuliConfig implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SikuliConfig.class);
	@Autowired
	private Environment env;

	@Autowired
	private ApplicationContext context;

	private String targetDevice;
	
	private String targeScerario;

	public String getTargeScerario() {
		return targeScerario;
	}

	public void setTargeScerario(String targeScerario) {
		this.targeScerario = targeScerario;
	}

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
		return new CustomScreen("src/main/resources/" + getTargeScerario() +"/" + getTargetDevice() + "/");
	}

	public void afterPropertiesSet() throws Exception {
		if (env.getActiveProfiles().length == 0) {
			throw new Exception("avtive Profile does not exist!!! Please set JVM argument like -Dspring.profiles.active=[device folder name]");
		} else {
			setTargetDevice(env.getActiveProfiles()[0]);
		}
		System.out.println("target deivce [" + getTargetDevice()
				+ "] is selected!");

		setTargeScerario(System.getProperty("target.scenario.name"));
		if (getTargeScerario() == null) {
			throw new Exception("avtive scenario does not exist!!! Please set JVM argument like -Dtarget.scenario.name=[scenario folder name]");
		}
		System.out.println("test scenario ["
				+ getTargeScerario() + "] is selected!");

	}
}
