package com.cloudcar.content.provider.api;

import java.util.Map;

import org.json.simple.JSONObject;

import com.cloudcar.content.exception.CPPException;

public interface ContentProviderExecutor {

	JSONObject execute( JSONObject request ) throws CPPException;

	JSONObject doPost( JSONObject postBody ) throws CPPException;

	JSONObject doGet( Map<String, Object> query ) throws CPPException;

}
