package com.cloudcar.common.json;

import java.security.InvalidParameterException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonConverter {

	private Properties	ruleMap;

	private JSONObject	resource;

	public JsonConverter( JSONObject resource, Properties ruleMap ) {
		if ( resource == null || ruleMap == null ) {
			throw new InvalidParameterException( "Json Converter expect to have resource and ruleMap for conversion." );
		}

		this.ruleMap = ruleMap;

		this.resource = resource;
	}

	public JSONObject convert() {

		return convertJSONNode( resource, "", "" );
	}

	private Object convertNode( Object root, String srcKey, String targetKey ) {

		if ( root instanceof JSONObject ) {
			return convertJSONNode( (JSONObject) root, srcKey, targetKey );
		} else if ( root instanceof JSONArray ) {
			return convertJSONArray( (JSONArray) root, srcKey, targetKey );
		} else {
			return root;
		}

	}

	@SuppressWarnings( "unchecked" )
	private Object convertJSONArray( JSONArray srcArray, String srcKey, String targetKey ) {

		JSONArray resultArray = new JSONArray();

		srcArray.forEach( node -> {
			Object newNode = convertNode( node, srcKey, targetKey );
			resultArray.add( newNode );
		} );

		return resultArray;
	}

	@SuppressWarnings( "unchecked" )
	private JSONObject convertJSONNode( JSONObject root, String srcKey, String targetKey ) {

		if ( isDelete( targetKey ) ) {
			return null;
		} else if ( isLeave( targetKey ) ) {
			return root;
		}
		JSONObject result = new JSONObject();

		root.forEach( ( key, value ) -> {
			String childSrcKey = srcKey.isEmpty() ? key.toString() : srcKey + "." + key.toString();
			String childTargetKey = ruleMap.getProperty( childSrcKey );

			if ( childTargetKey == null ) {
				result.put( key, value ); // no change;
			} else {
				AlterKey alterKey = KeyNodeTreeProcessor.INSTANCE.parseAlterKey( childTargetKey );
				Object childResult = convertNode( value, childSrcKey, childTargetKey );
				if ( childResult != null ) {
					String childKey = trimKey( childTargetKey );
					result.put( childKey, childResult );
				}
			}
		} );

		return result;

	}

	private String trimKey( String targetKey ) {

		return targetKey.substring( targetKey.lastIndexOf( '.' ) + 1 );
	}

	private boolean isLeave( String targetKey ) {

		// TODO Auto-generated method stub
		return false;
	}

	private boolean isDelete( String targetKey ) {

		// TODO Auto-generated method stub
		return false;
	}
}
