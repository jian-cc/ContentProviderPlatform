package com.cloudcar.content.platform.context;

public enum ContentTypeContextEnum {
	BUSINESS( "business", "business", "application/json", "application/json" ),

	PLACE( "place", "place", "application/json", "application/json" ),

	WEATHERE( "weather", "weather", "application/json", "application/json" );

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
