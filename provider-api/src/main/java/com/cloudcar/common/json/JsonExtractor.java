package com.cloudcar.common.json;

import java.security.InvalidParameterException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public enum JsonExtractor {

	INSTANCE;

	@SuppressWarnings( "unchecked" )
	public JSONArray extractArray( KeyTreeNode rulesTree, final JSONArray jArray ) {

		if ( rulesTree == null || jArray == null ) {
			return null;
		}

		JSONArray result = new JSONArray();
		if ( jArray.isEmpty() ) {
			return result;
		}

		jArray.forEach( element -> {
			Object resultElement = null;

			if ( element instanceof JSONObject ) {
				resultElement = extract( rulesTree, (JSONObject) element );
			} else if ( element instanceof JSONArray ) {
				resultElement = extractArray( rulesTree, (JSONArray) element );
			} else {
				resultElement = element;
			}

			if ( resultElement != null ) {
				result.add( resultElement );
			}
		} );

		return result;

	}

	public JSONObject extract( KeyTreeNode rulesTree, final JSONObject data ) {

		if ( rulesTree == null || data == null ) {
			return null;
		}

		final JSONObjectParser src = new JSONObjectParser( data );

		JSONObject result = new JSONObject();

		rulesTree.getChildren().forEach( ( key, node ) -> {
			Object element = internalExtract( node, src );
			if ( element != null ) {
				result.put( key, element );
			}
		} );

		return result;

	}

	private Object internalExtract( KeyTreeNode node, final JSONObjectParser src ) {

		if ( node.isArray() ) {
			if ( node.getAlterKey() == null ) {
				throw new InvalidParameterException( "Array nodes must have alterkey" );
			}

			Object data = src.getValue( node.getAlterKey().getKeyValue() );
			if ( data instanceof JSONArray ) {
				KeyTreeNode newNode = node.update( node.getAlterKey().getKeyValue() );
				return extractArray( newNode, (JSONArray) data );
			} else {
				return data;
			}
		} else if ( node.getAlterKey() != null ) {
			return src.getValue( node.getAlterKey().getKeyValue() );
		} else {
			JSONObject result = new JSONObject();
			node.getChildren().forEach( ( key, childNode ) -> {
				Object childResult = internalExtract( childNode, src );

				if ( childResult != null ) {
					result.put( key, childResult );
				}

			} );

			return result;
		}

	}

	public static void main( String[] args ) throws Exception {

		RuleConfiguration properties = new RuleConfiguration( "googleResultExtract.properties" );

		KeyTreeNode keyTree = KeyNodeTreeProcessor.INSTANCE.buildKeyTree( properties );

		JSONObject data = JsonLoader.INSTANCE.loadAsJSONObject( "googleResponse.json" );
		Object rawResult = ( (JSONArray) data.get( "results" ) ).get( 0 );

		JSONObject extract = JsonExtractor.INSTANCE.extract( keyTree, (JSONObject) rawResult );

		System.out.println( extract.toJSONString() );
	}

}
