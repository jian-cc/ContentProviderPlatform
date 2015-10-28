package com.cloudcar.content.provider.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloudcar.common.json.JSONObjectParser;
import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.provider.api.ContentProviderConverter;
import com.cloudcar.content.provider.api.ContentProviderExecutor;
import com.cloudcar.content.provider.api.ContentProviderHandler;
import com.cloudcar.search.interfaces.SearchRequest;
import com.cloudcar.search.interfaces.SearchResponse;
import com.cloudcar.search.interfaces.SearchResult;
import com.cloudcar.search.schema.business.BusinessRequest;
import com.cloudcar.search.schema.business.BusinessResponse;
import com.cloudcar.search.schema.business.BusinessResponse.Status;
import com.cloudcar.search.schema.business.BusinessSearchResult;
import com.cloudcar.search.schema.common.ProviderType;
import com.cloudcar.search.schema.configuration.ProviderConfig;
import com.google.gson.Gson;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class DefaultContentProviderHandler<Request extends SearchRequest, Response extends SearchResponse, Result extends SearchResult>
		implements ContentProviderHandler<Request, Response, Result>

{

	@Autowired
	private ContentProviderConverter<Request, Result>	converter;

	@Autowired
	private ContentProviderExecutor						executor;

	@Autowired
	private ProviderConfig								config;

	@Autowired
	public DefaultContentProviderHandler() {

	}

	@Override
	public String getProviderName() {

		return getConfig().getIdentifier();
	}

	@Override
	public ProviderType getSupportType() {

		return getConfig().getProviderType();
	}

	@Override
	public ContentProviderConverter<Request, Result> getConverter() {

		return this.converter;
	}

	@Override
	public ContentProviderExecutor getExecutor() {

		return this.executor;
	}

	@Override
	public Response processRequest( JSONObject request ) {

		if ( request == null ) {
			return null;
		}

		// TODO more validation code will be added here.

		JSONObject response = null;
		try {

			switch ( config.getProviderMethod() ) {

				case GET:
					Map<String, Object> query = converter.buildGetRequest( request );
					response = executor.doGet( query );
					break;
				case POST:
					JSONObject providerRequest = converter.buildPostRequest( request );
					response = executor.doPost( providerRequest );
					break;
				default:
					// throw exception
					return null;
			}

			return processRawResponse( response );

		}
		catch ( Exception e ) {
			return null; // TODO update later;
			// return converter.extractCommmonError( response, e );
		}

	}

	@SuppressWarnings( "unchecked" )
	protected Response processRawResponse( JSONObject rawResponse ) {

		String rootKey = config.getContentRootKey();

		BusinessResponse response = new BusinessResponse();
		response.setStatus( Status.SUCCESS );
		response.setResponseId( Long.toString( System.currentTimeMillis() ) );

		List<Object> results = new ArrayList<Object>();
		response.setResults( results );

		Object rawResults = JSONObjectParser.extract( rootKey, rawResponse );

		if ( rawResults instanceof JSONObject ) {
			Result result = converter.convertResult( (JSONObject) rawResults );
			results.add( result );
		} else if ( rawResults instanceof JSONArray ) {
			JSONArray rawArray = (JSONArray) rawResults;
			rawArray.forEach( json -> {
				Result result = converter.convertResult( (JSONObject) json );
				results.add( result );
			} );
		}

		return (Response) response;
	}

	public void setConverter( ContentProviderConverter<Request, Result> converter ) {

		this.converter = converter;
	}

	public void setExecutor( ContentProviderExecutor executor ) {

		this.executor = executor;
	}

	@Override
	public ProviderConfig getConfig() {

		return config;
	}

	public void setConfig( ProviderConfig config ) {

		this.config = config;
	}

	public static void main( String[] args ) throws Exception {

		DefaultContentProviderConverter<BusinessRequest, BusinessSearchResult> converter = new DefaultContentProviderConverter<BusinessRequest, BusinessSearchResult>(
				"googleResultExtract.properties" );

		DefaultContentProviderHandler<BusinessRequest, BusinessResponse, BusinessSearchResult> handler = new DefaultContentProviderHandler<BusinessRequest, BusinessResponse, BusinessSearchResult>();

		ProviderConfig config = JsonLoader.INSTANCE.loadAsJavaObject( "googleConfig.json", ProviderConfig.class );

		DefaultContentProviderExecutor executor = new DefaultContentProviderExecutor( config );

		handler.setConfig( config );
		handler.setConverter( converter );
		handler.setExecutor( executor );

		JSONObject request = JsonLoader.INSTANCE.loadAsJSONObject( "googleRequestSample.json" );

		// JSONObject data = JsonLoader.INSTANCE.loadAsJSONObject( "googleResponse.json" );

		// BusinessResponse response = handler.processRawResponse( data );

		BusinessResponse response = handler.processRequest( request );

		Gson gson = new Gson();
		String json = gson.toJson( response );

		System.out.println( json );

	}

	@Override
	public void handle( Message<JsonObject> message ) {

		JsonObject request = message.body();

		System.out.println( "Request is: " + request );

		try {
			Response response = this.processRequest( JsonLoader.INSTANCE.convertToJSON( request.toString() ) );

			Gson gson = new Gson();
			String resultStr = gson.toJson( response, BusinessResponse.class );

			JsonObject result = new JsonObject( resultStr );
			message.reply( result );
		}
		catch ( ParseException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.reply( "search failed" );
		}

	}

}
