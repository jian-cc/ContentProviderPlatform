package com.cloudcar.content.platform.app;

import org.springframework.context.ApplicationContext;

import com.cloudcar.content.platform.context.CPPApplicationContext;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

public class CPPLauncher {

	public static void main( String[] args ) throws Exception {

		System.out.println( "Launch Content Provider Service" );

		ApplicationContext context = CPPApplicationContext.INSTANCE.getContext();

		for ( String name : context.getBeanDefinitionNames() ) {
			System.out.println( "Bean name is: " + name );
		}

		// DefaultContentProviderHandler handler = (DefaultContentProviderHandler) context
		// .getBean( "googleBusinessHandler" );

		// System.out.println( "The handler is good" );

		// JSONObject request = JsonLoader.INSTANCE.loadAsJSONObject( "googleRequestSample.json" );

		// System.out.println( request );

		// JSONObject data = JsonLoader.INSTANCE.loadAsJSONObject( "googleResponse.json" );

		// BusinessResponse response = handler.processRawResponse( data );

		// SearchResponse response = handler.processRequest( request );

		// Gson gson = new Gson();
		// String json = gson.toJson( response );

		// System.out.println( json );

		Vertx.vertx().deployVerticle( (Verticle) context.getBean( "CPPServer" ) );

	}

}
