package com.cloudcar.common.json;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public enum JsonStretcher {

	INSTANCE;

	@SuppressWarnings( "unchecked" )
	public Map<String, Object> execute( JSONObject json ) {

		Map<String, Object> result = new HashMap<String, Object>();

		if ( json == null || json.isEmpty() ) {
			return result;
		}

		json.forEach( ( key, value ) -> {
			internalExecute( value, result, key.toString() );
		} );

		return result;

	}

	@SuppressWarnings( "unchecked" )
	private void internalExecute( Object data, Map<String, Object> result, String key ) {

		if ( data == null ) {
			return;
		}

		result.put( key, data );

		if ( data instanceof JSONObject ) {
			JSONObject json = (JSONObject) data;

			json.forEach( ( childKey, value ) -> {
				String currentKey = key + "." + childKey;
				internalExecute( value, result, currentKey );
			} );

		} else if ( data instanceof JSONArray ) {
			JSONArray jarray = (JSONArray) data;
			int[] count = new int[1];
			jarray.forEach( value -> {
				String currentKey = key + "[" + count[0] + "]";
				internalExecute( value, result, currentKey );
				count[0]++;
			} );
		}
	}
}
