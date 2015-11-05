package com.cloudcar.content.provider.business.google;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.provider.api.ContentProviderConverter;
import com.cloudcar.content.provider.api.ContentProviderExecutor;
import com.cloudcar.content.provider.api.ContentProviderHandler;
import com.cloudcar.content.provider.base.DefaultContentProviderExecutor;
import com.cloudcar.content.provider.base.DefaultContentProviderHandler;
import com.cloudcar.search.schema.business.BusinessSearchRequest;
import com.cloudcar.search.schema.business.BusinessSearchResponse;
import com.cloudcar.search.schema.business.BusinessSearchResult;
import com.cloudcar.search.schema.configuration.ProviderConfig;

@Configuration
public class GoogleBusinessConfiguration {

	@Bean
	public ProviderConfig googleBusinessConfig() throws Exception {

		return JsonLoader.INSTANCE.loadAsJavaObject( "googleConfig.json", ProviderConfig.class );
	}

	@Bean
	public ContentProviderExecutor googleBusinessExecutor( ProviderConfig googleBusinessConfig ) {

		return new DefaultContentProviderExecutor( googleBusinessConfig );
	}

	@Bean
	ContentProviderConverter<BusinessSearchResult> googleBusinessConverter() throws IOException {

		return new GoogleContentProviderConverter( "googleResultExtract.properties" );
	}

	@Bean
	ContentProviderHandler<BusinessSearchRequest, BusinessSearchResponse, BusinessSearchResult> googleBusinessHandler(
			ProviderConfig googleBusinessConfig, ContentProviderExecutor googleBusinessExecutor,
			ContentProviderConverter<BusinessSearchResult> googleBusinessConverter ) {

		DefaultContentProviderHandler<BusinessSearchRequest, BusinessSearchResponse, BusinessSearchResult> handler = new DefaultContentProviderHandler<BusinessSearchRequest, BusinessSearchResponse, BusinessSearchResult>();

		handler.setConfig( googleBusinessConfig );
		handler.setConverter( googleBusinessConverter );
		handler.setExecutor( googleBusinessExecutor );

		return handler;
	}

}