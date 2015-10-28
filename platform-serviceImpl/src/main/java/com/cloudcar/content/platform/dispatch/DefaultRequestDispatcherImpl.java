package com.cloudcar.content.platform.dispatch;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.cloudcar.content.platform.context.ContentTypeContextEnum;
import com.cloudcar.content.platform.provider.ProviderHandlerCache;
import com.cloudcar.content.provider.api.ContentProviderHandler;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class DefaultRequestDispatcherImpl implements RequestDispatcher {

	private final ContentTypeContextEnum	type;

	private EventBus						eventBus;

	private List<ContentProviderHandler>	providerHandlers;

	public DefaultRequestDispatcherImpl( ContentTypeContextEnum type, EventBus eventBus ) {
		this.type = type;

		this.eventBus = eventBus;

		providerHandlers = ProviderHandlerCache.INSTANCE.getProviderConfigForType( type );

		if ( providerHandlers == null || providerHandlers.isEmpty() ) {
			return;
		}

		for ( ContentProviderHandler handle : providerHandlers ) {
			String messageQueue = handle.getConfig().getMessageQueue();

			this.eventBus.consumer( messageQueue, handle );
		}

	}

	@Override
	public void dispatch( RoutingContext routingContext ) {

		System.out.println( "Type of dispatch is " + type );

		final JsonObject body = routingContext.getBodyAsJson();

		List<ContentProviderHandler> providerHandlers = ProviderHandlerCache.INSTANCE.getProviderConfigForType( type );

		if ( providerHandlers == null || providerHandlers.isEmpty() ) {
			return;
		}

		AtomicInteger count = new AtomicInteger();

		Handler<AsyncResult<Message<JsonObject>>> replyHandle = reply -> {

			JsonObject json = reply.result().body();

			int result = count.incrementAndGet();

			if ( result == providerHandlers.size() ) {
				System.out.println( "The data is: " + Json.encode( json ) );
				routingContext.response().putHeader( "content-type", "application/json" ).end( Json.encode( json ) );
			}
		};

		for ( ContentProviderHandler handle : providerHandlers ) {
			String messageQueue = handle.getConfig().getMessageQueue();

			this.eventBus.send( messageQueue, body, replyHandle );
		}

	}

}
