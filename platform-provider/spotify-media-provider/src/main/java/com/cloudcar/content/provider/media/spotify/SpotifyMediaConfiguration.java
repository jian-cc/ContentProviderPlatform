package com.cloudcar.content.provider.media.spotify;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.provider.api.ContentProviderConverter;
import com.cloudcar.content.provider.api.ContentProviderExecutor;
import com.cloudcar.content.provider.api.ContentProviderHandler;
import com.cloudcar.content.provider.base.DefaultContentProviderExecutor;
import com.cloudcar.search.schema.configuration.ProviderConfig;
import com.cloudcar.search.schema.media.MediaSearchRequest;
import com.cloudcar.search.schema.media.MediaSearchResponse;
import com.cloudcar.search.schema.media.MediaSearchResult;

@Configuration
public class SpotifyMediaConfiguration {

	@Bean
	public ProviderConfig spotifyMediaConfig() throws Exception {

		return JsonLoader.INSTANCE.loadAsJavaObject( "spotifyConfig.json", ProviderConfig.class );
	}

	@Bean
	public ContentProviderExecutor spotifyMediaExecutor( ProviderConfig spotifyMediaConfig ) {

		return new DefaultContentProviderExecutor( spotifyMediaConfig );
	}

	@Bean
	ContentProviderConverter<MediaSearchResult> spotifyMediaConverter() throws IOException {

		return new SpotifyMediaContentProviderConverter( "spotifyResultRules.properties", "spotifyGetRules.properties",
				null, null );
	}

	@Bean
	ContentProviderHandler<MediaSearchRequest, MediaSearchResponse, MediaSearchResult> spotifyMediaHandler(
			ProviderConfig spotifyMediaConfig, ContentProviderExecutor spotifyMediaExecutor,
			ContentProviderConverter<MediaSearchResult> spotifyMediaConverter ) {

		SpotifyMediaContentProviderHandler handler = new SpotifyMediaContentProviderHandler();

		handler.setConfig( spotifyMediaConfig );
		handler.setExecutor( spotifyMediaExecutor );
		handler.setConverter( spotifyMediaConverter );

		return handler;
	}

}