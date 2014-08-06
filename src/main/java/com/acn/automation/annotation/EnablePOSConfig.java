package com.acn.automation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.acn.automation.config.SikuliConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes=SikuliConfig.class, loader=AnnotationConfigContextLoader.class)
public @interface EnablePOSConfig {
	String value() default "";

}
