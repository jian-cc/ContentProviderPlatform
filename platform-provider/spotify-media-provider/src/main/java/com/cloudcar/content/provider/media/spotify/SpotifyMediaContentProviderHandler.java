package com.cloudcar.content.provider.media.spotify;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.cloudcar.content.provider.base.DefaultContentProviderHandler;
import com.cloudcar.search.schema.media.MediaSearchRequest;
import com.cloudcar.search.schema.media.MediaSearchResponse;
import com.cloudcar.search.schema.media.MediaSearchResult;

public class SpotifyMediaContentProviderHandler
		extends DefaultContentProviderHandler<MediaSearchRequest, MediaSearchResponse, MediaSearchResult> {

	@SuppressWarnings( "unchecked" )
	@Override
	protected JSONArray extractRawResults( JSONObject response ) {

		String rootKey = getConfig().getContentRootKey();

		JSONArray result = new JSONArray();

		response.forEach( ( key, value ) -> {
			if ( value instanceof JSONObject ) {
				JSONObject json = (JSONObject) value;

				Object data = json.get( rootKey );
				if ( data != null && data instanceof JSONArray ) {
					JSONArray items = (JSONArray) data;
					items.forEach( item -> result.add( item ) );
				}
			}
		} );

		return result;

	}

}
