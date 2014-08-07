package com.accenture.mobility.swv.config;

import com.accenture.mobility.swv.sikuli.CustomScreen;
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

@Configuration
@PropertySource(value = {"classpath:${target.scenario.name}/${target.scenario.name}.properties",
        "classpath:${target.scenario.name}/${spring.profiles.active}.properties", "classpath:swv.properties"}, ignoreResourceNotFound = true)
public class SWVConfig implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SWVConfig.class);
    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext context;

    private String targetDevice;

    private String targeScerario;

    private String appPath;

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

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

    @Bean(name = "propertySourcesPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void afterPropertiesSet() throws Exception {
        if (env.getProperty("app.program.path") == null) {
            throw new Exception("pos program path is not defined!!");
        }else{
            setAppPath(env.getProperty("app.program.path"));
        }

        if (env.getActiveProfiles().length == 0) {
            throw new Exception("active Profile does not exist!!! Please set JVM argument like -Dspring.profiles.active=[device folder name]");
        } else {
            setTargetDevice(env.getActiveProfiles()[0]);
        }

        setTargeScerario(System.getProperty("target.scenario.name"));
        if (getTargeScerario() == null) {
            throw new Exception("active scenario does not exist!!! Please set JVM argument like -Dtarget.scenario.name=[scenario folder name]");
        }


        System.out.println("######################## SWV INFO #############################");
        System.out.println("  + app Path:       [" + getAppPath()+"]");
        System.out.println("  + target Scenario:[" + getTargeScerario()+"]");
        System.out.println("  + target device:  [" + getTargetDevice()+"]");
        System.out.println("###############################################################");

    }
}
