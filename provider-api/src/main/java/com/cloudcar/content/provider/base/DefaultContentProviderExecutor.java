package com.cloudcar.content.provider.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
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
	public JSONObject execute( JSONObject request, Map<String, Object> header ) throws CPPException {

		switch ( config.getProviderMethod() ) {

			case GET:
				Map<String, Object> query = buildQuery( request );
				return doGet( query, header );
			case POST:
				return doPost( request, header );
			default:
				// throw exception
				return null;
		}
	}

	@Override
	public JSONObject doGet( Map<String, Object> query, Map<String, Object> header ) {

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

		Builder builder = setHeader( currentConnect, header );

		String response = builder.get( String.class );

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
	public JSONObject doPost( JSONObject request, Map<String, Object> header ) {

		Response response = null;
		JSONObject result = null;

		try {
			Builder builder = setHeader( this.connect, header );

			response = builder.post( Entity.json( request ) );

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

	protected Builder setHeader( ResteasyWebTarget currConnect, Map<String, Object> header ) {

		Builder builder = currConnect.request();

		if ( header != null && !header.isEmpty() ) {
			header.forEach( ( key, value ) -> builder.header( key, value ) );
		}

		if ( config.getProviderContentType() == null ) {
			builder.accept( MediaType.APPLICATION_JSON );
		} else {
			builder.accept( config.getProviderContentType() );
		}

		return builder;
	}

	public static void main( String[] args ) {

		try {
			JSONObject request = JsonLoader.INSTANCE.loadAsJSONObject( "googleRequestSample.json" );

			System.out.println( "request is: " + request );

			ProviderConfig config = JsonLoader.INSTANCE.loadAsJavaObject( "googleConfig.json", ProviderConfig.class );

			System.out.println( "config is: " + config );

			DefaultContentProviderExecutor executor = new DefaultContentProviderExecutor( config );

			JSONObject result = executor.execute( request, null );

			System.out.println( "The result is: " + result );

		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
