package com.cloudcar.content.provider.media.spotify;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.json.simple.JSONObject;

import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.provider.base.DefaultContentProviderConverter;
import com.cloudcar.search.schema.common.CredentialInfo;
import com.cloudcar.search.schema.common.Provider;
import com.cloudcar.search.schema.common.ProviderInfo;
import com.cloudcar.search.schema.common.ProviderType;
import com.cloudcar.search.schema.media.MediaSearchRequest;
import com.cloudcar.search.schema.media.MediaSearchResult;

public class SpotifyMediaContentProviderConverter extends DefaultContentProviderConverter<MediaSearchResult> {

	public SpotifyMediaContentProviderConverter( String resultConfig ) throws IOException {
		super( resultConfig );
	}

	public SpotifyMediaContentProviderConverter( String resultConfig, String getConfig, String headerConfig,
			String postConfig ) throws IOException {
		super( resultConfig, getConfig, headerConfig, postConfig );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public MediaSearchResult convertResult( JSONObject rawResult ) {

		MediaSearchResult result = super.convertResult( rawResult );

		result.setProvider( Provider.SPOTIFY.name() );

		return result;
	}

	protected Class<MediaSearchResult> getResultClass() {

		return MediaSearchResult.class;
	}

	@SuppressWarnings( "unchecked" )
	@Override
	protected void addRawData( JSONObject result, Object rawResult ) {

		result.put( "provider_detail", rawResult );
	}

	@Override
	public Map<String, Object> buildRequestHeaders( JSONObject stdRequest ) {

		Map<String, Object> header = new HashMap<String, Object>();

		try {
			MediaSearchRequest request = JsonLoader.INSTANCE.convertToJava( stdRequest, MediaSearchRequest.class );

			Optional<ProviderInfo> spotify = request.getProviders().stream().filter( provider -> {
				return provider.getType() == ProviderType.MEDIA && provider.getName().equals( "spotify" );
			} ).findFirst();

			if ( spotify.isPresent() ) {
				CredentialInfo credential = spotify.get().getCredentialInfo();
				if ( credential != null ) {
					header.put( "authorization", credential.getAdditionalProperties().get( "access_token" ) );
				}

			}
		}
		catch ( IOException e ) {

			e.printStackTrace();
		}

		return header;

	}

	public static void main( String[] args ) {

		try {
			JSONObject request = JsonLoader.INSTANCE.loadAsJSONObject( "spotifyRequestSample.json" );
			System.out.println( "request: " + request.toJSONString() );

			// GsonBuilder builder = new GsonBuilder();
			// builder.enableComplexMapKeySerialization();
			// Gson gson = builder.create();
			// MediaSearchCriteria result = gson.fromJson( request.toJSONString(), MediaSearchCriteria.class );

			MediaSearchRequest requestJava = JsonLoader.INSTANCE.convertToJava( request, MediaSearchRequest.class );
		}
		catch ( Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
