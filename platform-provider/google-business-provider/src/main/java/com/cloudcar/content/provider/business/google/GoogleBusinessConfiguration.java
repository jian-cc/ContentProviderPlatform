package com.cloudcar.content.provider.business.google;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudcar.common.json.JsonLoader;
import com.cloudcar.content.provider.api.ContentProviderConverter;
import com.cloudcar.content.provider.api.ContentProviderExecutor;
import com.cloudcar.content.provider.api.ContentProviderHandler;
import com.cloudcar.content.provider.base.DefaultContentProviderConverter;
import com.cloudcar.content.provider.base.DefaultContentProviderExecutor;
import com.cloudcar.content.provider.base.DefaultContentProviderHandler;
import com.cloudcar.search.schema.business.BusinessRequest;
import com.cloudcar.search.schema.business.BusinessResponse;
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
	ContentProviderConverter<BusinessRequest, BusinessSearchResult> googleBusinessConverter() throws IOException {

		return new DefaultContentProviderConverter<BusinessRequest, BusinessSearchResult>(
				"googleResultExtract.properties" );
	}

	@Bean
	ContentProviderHandler<BusinessRequest, BusinessResponse, BusinessSearchResult> googleBusinessHandler() {

		return new DefaultContentProviderHandler<BusinessRequest, BusinessResponse, BusinessSearchResult>();
	}

}