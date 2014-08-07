package com.accenture.mobility.swv.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.accenture.mobility.swv.config.SWVConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.accenture.mobility.swv.config.SikuliConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {SWVConfig.class, SikuliConfig.class}, loader = AnnotationConfigContextLoader.class)
public @interface EnableSWVConfig {
    String value() default "";

}
