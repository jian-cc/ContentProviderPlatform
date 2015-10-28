package com.cloudcar.content.platform.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public enum CPPApplicationContext {
	INSTANCE( BaseSpringConfiguration.class );

	private final ApplicationContext context;

	CPPApplicationContext( Class<?> configureClass ) {
		context = new AnnotationConfigApplicationContext( configureClass );
	}

	public String getProperties( String key ) {

		return key == null ? null : context.getEnvironment().getProperty( key );
	}

	public Object getBean( String beanName ) {

		return beanName == null ? null : context.getBean( beanName );
	}

	public ApplicationContext getContext() {

		return context;
	}

}
