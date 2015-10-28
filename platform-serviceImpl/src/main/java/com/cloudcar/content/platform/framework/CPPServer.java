package com.cloudcar.content.platform.framework;

import org.springframework.stereotype.Service;

import com.cloudcar.content.platform.context.CPPApplicationContext;
import com.cloudcar.content.platform.context.ContentTypeContextEnum;
import com.cloudcar.content.platform.context.PropertyNameConstants;
import com.cloudcar.content.platform.dispatch.RequestDispatcher;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

@Service
public class CPPServer extends AbstractVerticle implements PropertyNameConstants {

	@Override
	public void start() {

		HttpServer server = vertx.createHttpServer();

		Router router = Router.router( vertx );

		initService( router );

		server.requestHandler( router::accept ).listen( 8080 );
	}

	private void initService( Router router ) {

		CPPApplicationContext context = CPPApplicationContext.INSTANCE;
		String baseServicePath = context.getProperties( PLATFORM_BASE_URI ) + context.getProperties( PLATFORM_VERSION );

		router.route( baseServicePath + "*" ).handler( BodyHandler.create() );

		for ( ContentTypeContextEnum content : ContentTypeContextEnum.values() ) {
			String contentServicePath = baseServicePath + "/" + content.getEndPoint();

			RequestDispatcher dispatcher = RequestDispatcher.createDispatcher( content, this.vertx.eventBus() );

			router.post( contentServicePath ).handler( dispatcher::dispatch );
		}
	}

}
