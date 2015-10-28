package com.cloudcar.content.platform.dispatch;

import com.cloudcar.content.platform.context.ContentTypeContextEnum;

import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.RoutingContext;

public interface RequestDispatcher {

	void dispatch( RoutingContext routingContext );

	public static RequestDispatcher createDispatcher( ContentTypeContextEnum type, EventBus eventBus ) {

		return new DefaultRequestDispatcherImpl( type, eventBus );
	}

}
