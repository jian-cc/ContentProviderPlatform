package com.cloudcar.content.platform.context;

public enum ContentTypeContextEnum {
	BUSINESS( "BUSINESS", "business", "application/json", "application/json" ),

	PLACE( "PLACE", "place", "application/json", "application/json" ),

	MEDIA( "MEDIA", "media", "application/json", "application/json" ),

	WEATHER( "WEATHER", "weather", "application/json", "application/json" );

	private final String	name;

	private final String	endPoint;

	private final String	defaultProductType;

	private final String	defaultContentType;

	ContentTypeContextEnum( String name, String endPoint, String defaultProductType, String defaultContentType ) {

		this.name = name;

		this.endPoint = endPoint;

		this.defaultProductType = defaultProductType;

		this.defaultContentType = defaultContentType;
	}

	public String getName() {

		return name;
	}

	public String getEndPoint() {

		return endPoint;
	}

	public String getDefaultProductType() {

		return defaultProductType;
	}

	public String getDefaultContentType() {

		return defaultContentType;
	}

}
