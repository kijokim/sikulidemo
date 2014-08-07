package com.accenture.mobility.swv.config;

import com.accenture.mobility.swv.sikuli.CustomScreen;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SikuliConfig {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SikuliConfig.class);


    @Autowired
    private ApplicationContext context;

    @Bean
    @DependsOn(value = {"propertySourcesPlaceholderConfigurer"})
    public Screen customScreen() {
        SWVConfig swvConfig = context.getBean(SWVConfig.class);
        return new CustomScreen("src/main/resources/" + swvConfig.getTargeScerario() + "/" + swvConfig.getTargetDevice() + "/");
    }

}
