package com.cloudcar.common.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RuleConfiguration extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RuleConfiguration( String propertiesFileName ) throws IOException {
		super();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream( propertiesFileName );

		if ( inputStream != null ) {
			load( inputStream );
		} else {
			throw new FileNotFoundException( "property file '" + propertiesFileName + "' not found in the classpath" );
		}
	}
}
