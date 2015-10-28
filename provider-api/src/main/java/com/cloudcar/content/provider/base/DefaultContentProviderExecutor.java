package com.cloudcar.content.provider.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.exception.CPPException;
import com.cloudcar.content.provider.api.ContentProviderExecutor;
import com.cloudcar.search.schema.configuration.ProviderConfig;
import com.cloudcar.search.schema.configuration.ProviderConfig.ProviderMethod;

public class DefaultContentProviderExecutor implements ContentProviderExecutor {

	ResteasyWebTarget	connect;

	ProviderConfig		config;

	ProviderMethod		method;

	String				key;

	public DefaultContentProviderExecutor( ProviderConfig config ) {

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append( config.getProviderUrl() );

		if ( config.getProviderPort() != null ) {
			urlBuilder.append( ":" ).append( config.getProviderPort() );
		}

		if ( config.getProviderEndpoint() != null ) {
			urlBuilder.append( "/" ).append( config.getProviderEndpoint() );
		}
		String targetUri = urlBuilder.toString();

		// Will update to add proxy
		ResteasyClient client = new ResteasyClientBuilder().build();
		connect = client.target( targetUri );

		this.config = config;

	}

	@Override
	public JSONObject execute( JSONObject request ) throws CPPException {

		switch ( config.getProviderMethod() ) {

			case GET:
				Map<String, Object> query = buildQuery( request );
				return doGet( query );
			case POST:
				return doPost( request );
			default:
				// throw exception
				return null;
		}
	}

	@Override
	public JSONObject doGet( Map<String, Object> query ) {

		MultivaluedMap<String, Object> requestMap = new MultivaluedMapImpl<String, Object>();

		if ( config.getProviderKey() != null ) {
			requestMap.add( "key", config.getProviderKey() );
		}

		if ( query != null && !query.isEmpty() ) {
			query.forEach( ( key, value ) -> {
				if ( value instanceof List ) {
					requestMap.addAll( key, (List) value );
				} else {
					requestMap.add( key, value );
				}
			} );
		}

		ResteasyWebTarget currentConnect = connect.queryParams( requestMap );

		String response = currentConnect.request( MediaType.APPLICATION_JSON ).get( String.class );

		JSONParser parser = new JSONParser();

		JSONObject newResponse = null;
		try {
			newResponse = (JSONObject) ( parser.parse( response ) );

			newResponse.forEach( ( key, data ) -> {
				System.out.println(
						String.format( "The value for key of %s type is %s", key, data.getClass().getSimpleName() ) );
			} );
		}
		catch ( ParseException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * List result = (List) response.get( "results" );
		 * 
		 * result.forEach( data -> { System.out.println( "The result data type is: " + data.getClass().getSimpleName()
		 * ); } );
		 */

		// System.out.println( "The result type is: " + result.getClass().getSimpleName() );

		System.out.println( "response is: " + response );

		// int status = response.getStatus();
		// System.out.println( "The status is: " + status );

		// Object entity = response.getEntity();

		// response.close();

		return newResponse;
	}

	protected Map<String, Object> buildQuery( JSONObject request ) {

		Map<String, Object> result = new HashMap<String, Object>();

		JSONObject criteria = (JSONObject) ( request.get( "search_criteria" ) );

		JSONObject location = (JSONObject) ( criteria.get( "location" ) );

		JSONObject geocode = (JSONObject) ( location.get( "geocode" ) );

		String geoLocation = geocode.get( "latitude" ).toString() + "," + geocode.get( "longitude" ).toString();

		result.put( "location", geoLocation );

		result.put( "radius", location.get( "radius" ).toString() );

		Object categories = criteria.get( "category" );

		result.put( "query", categories );

		return result;
	}

	@Override
	public JSONObject doPost( JSONObject request ) {

		Response response = null;
		JSONObject result = null;

		try {
			response = connect.request().accept( "application/json" ).post( Entity.json( request ) );

			return (JSONObject) ( response.getEntity() );

		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if ( response != null ) {
				response.close();
			}
		}

		return result;
	}

	public static void main( String[] args ) {

		try {
			JSONObject request = JsonLoader.INSTANCE.loadAsJSONObject( "googleRequestSample.json" );

			System.out.println( "request is: " + request );

			ProviderConfig config = JsonLoader.INSTANCE.loadAsJavaObject( "googleConfig.json", ProviderConfig.class );

			System.out.println( "config is: " + config );

			DefaultContentProviderExecutor executor = new DefaultContentProviderExecutor( config );

			JSONObject result = executor.execute( request );

			System.out.println( "The result is: " + result );

		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
