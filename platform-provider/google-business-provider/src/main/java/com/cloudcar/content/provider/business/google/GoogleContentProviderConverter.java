package com.cloudcar.content.provider.business.google;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cloudcar.content.provider.base.DefaultContentProviderConverter;
import com.cloudcar.search.schema.business.BusinessSearchResult;

public class GoogleContentProviderConverter extends DefaultContentProviderConverter<BusinessSearchResult> {

	@Deprecated
	public GoogleContentProviderConverter( String resultConfig ) throws IOException {

		super( resultConfig );
	}

	public GoogleContentProviderConverter( String resultConfig, String getConfig, String headerConfig,
			String postConfig ) throws IOException {
		super( resultConfig, getConfig, headerConfig, postConfig );
	}

	@Override
	protected Class<BusinessSearchResult> getResultClass() {

		return BusinessSearchResult.class;
	}

	@SuppressWarnings( "unchecked" )
	@Override
	protected void addRawData( JSONObject result, Object rawResult ) {

		JSONArray rawArray = new JSONArray();
		rawArray.add( rawResult );
		result.put( "provider_detail", rawArray );
	}

	@Override
	public Map<String, Object> buildGetRequest( JSONObject stdRequest ) {

		Map<String, Object> result = new HashMap<String, Object>();

		JSONObject criteria = (JSONObject) ( stdRequest.get( "search_criteria" ) );

		JSONObject location = (JSONObject) ( criteria.get( "location" ) );

		JSONObject geocode = (JSONObject) ( location.get( "geocode" ) );

		String geoLocation = geocode.get( "latitude" ).toString() + "," + geocode.get( "longitude" ).toString();

		result.put( "location", geoLocation );

		result.put( "radius", location.get( "radius" ).toString() );

		JSONArray categories = (JSONArray) criteria.get( "category" );

		result.put( "query", this.convertJSONArray( categories ) );

		return result;

	}

}
