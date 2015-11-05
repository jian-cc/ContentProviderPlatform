package com.cloudcar.content.platform.app;

import org.springframework.context.ApplicationContext;

import com.cloudcar.content.platform.context.CPPApplicationContext;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

public class CPPLauncher {

	public static void main( String[] args ) throws Exception {

		System.out.println( "Launch Content Provider Service" );

		ApplicationContext context = CPPApplicationContext.INSTANCE.getContext();

		Vertx.vertx().deployVerticle( (Verticle) context.getBean( "CPPServer" ) );

	}

}
