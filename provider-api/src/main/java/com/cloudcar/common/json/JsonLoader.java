package com.cloudcar.common.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum JsonLoader {

	INSTANCE;

	private JSONParser		parser;

	private ObjectMapper	mapper;

	JsonLoader() {
		parser = new JSONParser();

		mapper = new ObjectMapper();
	}

	public JSONObject convertToJSON( String data ) throws ParseException {

		return (JSONObject) parser.parse( data );
	}

	// TODO add more exception handling later
	public JSONObject loadAsJSONObject( String fileName ) throws Exception {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream( fileName );

		if ( in == null ) {
			// TODO throw an exception
			System.out.println( "cannot get resources" );
			System.exit( 1 );
		}

		Reader reader = new InputStreamReader( in );

		Object result = parser.parse( reader );

		return (JSONObject) result;

	}

	public <T> T loadAsJavaObject( String fileName, Class<T> type ) throws Exception {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream( fileName );

		if ( in == null ) {
			// TODO throw an exception
			System.out.println( "cannot get resources" );
			System.exit( 1 );
		}

		/*
		 * Gson gson = new Gson(); return gson.fromJson( jsonReader, type );
		 */

		return mapper.readValue( in, type );
	}

	public <T> T convertToJava( JSONObject data, Class<T> type )
			throws JsonParseException, JsonMappingException, IOException {

		return mapper.readValue( data.toString(), type );

	}

}
