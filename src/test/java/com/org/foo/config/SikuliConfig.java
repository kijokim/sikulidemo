package com.org.foo.config;

import org.sikuli.script.Pattern;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:${spring.profiles.active:default}.properties")
public class SikuliConfig implements InitializingBean {

	@Autowired
	private Environment env;

	@Bean
	public Pattern customPattern() {
		return new CustomPattern("src/main/resources/"+env.getActiveProfiles()[0] +  "/");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(env.getProperty("key1"));
	}
}
