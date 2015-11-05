package com.cloudcar.content.provider.api;

import org.json.simple.JSONObject;

import com.cloudcar.search.interfaces.SearchRequest;
import com.cloudcar.search.interfaces.SearchResponse;
import com.cloudcar.search.interfaces.SearchResult;
import com.cloudcar.search.schema.common.ProviderType;
import com.cloudcar.search.schema.configuration.ProviderConfig;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public interface ContentProviderHandler<Request extends SearchRequest, Response extends SearchResponse, Result extends SearchResult>
		extends Handler<Message<JsonObject>> {

	String getProviderName();

	ProviderType getSupportType();

	ContentProviderConverter<Result> getConverter();

	ContentProviderExecutor getExecutor();

	Response processRequest( JSONObject request );

	ProviderConfig getConfig();

}
