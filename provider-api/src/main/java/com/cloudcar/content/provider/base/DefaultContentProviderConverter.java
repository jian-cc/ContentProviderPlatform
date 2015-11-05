package com.cloudcar.content.provider.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cloudcar.common.json.JsonExtractor;
import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.common.json.KeyNodeTreeProcessor;
import com.cloudcar.common.json.KeyTreeNode;
import com.cloudcar.common.json.RuleConfiguration;
import com.cloudcar.content.provider.api.ContentProviderConverter;
import com.cloudcar.search.interfaces.SearchResult;

public class DefaultContentProviderConverter<Result extends SearchResult> implements ContentProviderConverter<Result> {

	private final KeyTreeNode	resultRules;

	private final KeyTreeNode	getRules;

	private final KeyTreeNode	headerRules;

	private final KeyTreeNode	postRules;

	public DefaultContentProviderConverter( String resultConfig ) throws IOException {

		this( resultConfig, null, null, null );
	}

	public DefaultContentProviderConverter( String resultConfig, String getConfig, String headerConfig,
			String postConfig ) throws IOException {

		resultRules = resultConfig == null ? null : initializeRules( resultConfig );

		getRules = getConfig == null ? null : initializeRules( getConfig );

		headerRules = headerConfig == null ? null : initializeRules( headerConfig );

		postRules = postConfig == null ? null : initializeRules( postConfig );
	}

	private KeyTreeNode initializeRules( String configFileName ) throws IOException {

		RuleConfiguration convertRules = new RuleConfiguration( configFileName );

		return KeyNodeTreeProcessor.INSTANCE.buildKeyTree( convertRules );
	}

	@Override
	public JSONObject buildPostRequest( JSONObject stdRequest ) {

		return postRules == null ? null : JsonExtractor.INSTANCE.extract( postRules, (JSONObject) stdRequest );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public Result convertResult( JSONObject rawResult ) {

		JSONObject result = JsonExtractor.INSTANCE.extract( resultRules, (JSONObject) rawResult );
		addRawData( result, rawResult );

		try {
			System.out.println( "The result is: " + result.toJSONString() );
			return JsonLoader.INSTANCE.convertToJava( result, getResultClass() );
		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Class<Result> getResultClass() {

		throw new UnsupportedOperationException( "getResultClass() need to be implemented by child class" );
	}

	@SuppressWarnings( "unchecked" )
	protected void addRawData( JSONObject result, Object rawResult ) {

		throw new UnsupportedOperationException( "addRawData() need to be implemented by child class" );
	}

	@Override
	public Map<String, Object> buildGetRequest( JSONObject stdRequest ) {

		if ( getRules == null ) {
			return null;
		}

		Map<String, Object> extractResult = JsonExtractor.INSTANCE.extract( getRules, stdRequest );
		if ( extractResult == null ) {
			return null;
		}

		Map<String, Object> result = new HashMap<String, Object>();

		extractResult.forEach( ( key, value ) -> {
			if ( value instanceof JSONArray ) {
				result.put( key, convertJSONArray( (JSONArray) value ) );
			} else {
				result.put( key, value );
			}
		} );

		return result;

	}

	protected String convertJSONArray( JSONArray array ) {

		StringBuilder builder = new StringBuilder();

		array.forEach( json -> builder.append( json.toString() ).append( "," ) );

		return builder.substring( 0, builder.length() - 1 );
	}

	@Override
	public Map<String, Object> buildRequestHeaders( JSONObject stdRequest ) {

		return headerRules == null ? null : JsonExtractor.INSTANCE.extract( headerRules, stdRequest );
	}

}
