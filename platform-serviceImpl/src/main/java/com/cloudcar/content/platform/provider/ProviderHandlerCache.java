package com.cloudcar.content.platform.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudcar.content.platform.context.CPPApplicationContext;
import com.cloudcar.content.platform.context.ContentTypeContextEnum;
import com.cloudcar.content.provider.api.ContentProviderHandler;

public enum ProviderHandlerCache {

	INSTANCE;

	private Map<ContentTypeContextEnum, List<ContentProviderHandler>> providerMap = new HashMap<ContentTypeContextEnum, List<ContentProviderHandler>>();

	private ProviderHandlerCache() {
		CPPApplicationContext context = CPPApplicationContext.INSTANCE;

		String[] beanNames = context.getContext().getBeanNamesForType( ContentProviderHandler.class );
		for ( String beanName : beanNames ) {
			ContentProviderHandler handler = (ContentProviderHandler) context.getBean( beanName );

			ContentTypeContextEnum key = ContentTypeContextEnum.valueOf( handler.getSupportType().name() );

			List<ContentProviderHandler> providers = providerMap.get( key );
			if ( providers == null ) {
				providers = new ArrayList<ContentProviderHandler>();
				providerMap.put( key, providers );
			}

			providers.add( handler );
		}
	}

	public List<ContentProviderHandler> getProviderConfigForType( ContentTypeContextEnum type ) {

		return providerMap.get( type );
	}

	public static void main( String[] args ) {

		ProviderHandlerCache instance = ProviderHandlerCache.INSTANCE;

		List<ContentProviderHandler> providers = instance.getProviderConfigForType( ContentTypeContextEnum.BUSINESS );

		System.out.println( "The number of providers is: " + providers.size() );
	}

}
