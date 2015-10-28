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
import com.cloudcar.search.interfaces.SearchRequest;
import com.cloudcar.search.interfaces.SearchResult;
import com.cloudcar.search.schema.business.BusinessSearchResult;

public class DefaultContentProviderConverter<Request extends SearchRequest, Result extends SearchResult>
		implements ContentProviderConverter<Request, Result> {

	private final KeyTreeNode rulesTree;

	public DefaultContentProviderConverter( String configFileName ) throws IOException {

		RuleConfiguration convertRules = new RuleConfiguration( configFileName );

		rulesTree = KeyNodeTreeProcessor.INSTANCE.buildKeyTree( convertRules );
	}

	@Override
	public JSONObject buildPostRequest( JSONObject stdRequest ) {

		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public Result convertResult( JSONObject rawResult ) {

		JSONObject result = JsonExtractor.INSTANCE.extract( rulesTree, (JSONObject) rawResult );
		addRawData( result, rawResult );

		try {
			return (Result) ( JsonLoader.INSTANCE.convertToJava( result, BusinessSearchResult.class ) );
		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings( "unchecked" )
	private void addRawData( JSONObject result, Object rawResult ) {

		JSONArray rawArray = new JSONArray();
		rawArray.add( rawResult );
		result.put( "provider_detail", rawArray );
	}

	@Override
	public Map<String, Object> buildGetRequest( JSONObject request ) {

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

}
