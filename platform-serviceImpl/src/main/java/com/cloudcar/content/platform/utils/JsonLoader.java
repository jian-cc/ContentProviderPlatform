package com.cloudcar.content.platform.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public enum JsonLoader {

	INSTANCE;

	public <T> T loadFromJsonFile( String fileName, Class<T> type ) throws FileNotFoundException {

		JsonReader jsonReader = new JsonReader( new FileReader( "jsonFile.json" ) );

		Gson gson = new Gson();
		return gson.fromJson( jsonReader, type );
	}

}
