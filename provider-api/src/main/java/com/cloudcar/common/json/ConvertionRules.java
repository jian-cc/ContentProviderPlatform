package com.cloudcar.common.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConvertionRules extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1114270259065300042L;

	public ConvertionRules( String propertiesFileName ) throws IOException {
		super();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream( propertiesFileName );

		if ( inputStream != null ) {
			load( inputStream );
		} else {
			throw new FileNotFoundException( "property file '" + propertiesFileName + "' not found in the classpath" );
		}
	}

}
