package com.cloudcar.content.provider.google;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfig {

	@Bean
	public ProviderConfig googleProvider() {

		return new ProviderConfig();
	}
}
