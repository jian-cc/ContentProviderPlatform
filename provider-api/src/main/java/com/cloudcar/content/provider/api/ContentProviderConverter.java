package com.cloudcar.content.provider.api;

import java.util.Map;

import org.json.simple.JSONObject;

import com.cloudcar.search.interfaces.SearchResult;

public interface ContentProviderConverter<Result extends SearchResult> {

	JSONObject buildPostRequest( JSONObject stdRequest );

	Map<String, Object> buildGetRequest( JSONObject stdRequest );

	Map<String, Object> buildRequestHeaders( JSONObject stdRequest );

	Result convertResult( JSONObject rawResult );

}
