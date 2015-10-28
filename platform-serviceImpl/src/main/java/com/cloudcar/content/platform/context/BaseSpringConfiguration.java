package com.cloudcar.content.platform.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( value = { "classpath:application.properties" } )
@ComponentScan( "com.cloudcar.content.platform, com.cloudcar.content.provider" )
public class BaseSpringConfiguration {

}
