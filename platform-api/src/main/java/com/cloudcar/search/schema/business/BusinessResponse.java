
package com.cloudcar.search.schema.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.cloudcar.search.interfaces.SearchResponse;
import com.cloudcar.search.schema.common.ErrorContent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * business response
 * <p>
 * information of business search response
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "status",
    "response_id",
    "search_criteria",
    "error_content",
    "results"
})
public class BusinessResponse implements SearchResponse
{

    @JsonProperty("status")
    private BusinessResponse.Status status;
    /**
     * unique id for this search response
     * 
     */
    @JsonProperty("response_id")
    private String responseId;
    /**
     * business search criteria
     * <p>
     * aggregate criteria information for business search. We expect at least some information is available
     * 
     */
    @JsonProperty("search_criteria")
    private SearchCriteria searchCriteria;
    /**
     * error content
     * <p>
     * information of common error content
     * 
     */
    @JsonProperty("error_content")
    private ErrorContent errorContent;
    /**
     * it will return when response status is success
     * 
     */
    @JsonProperty("results")
    private List<Object> results = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public BusinessResponse.Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(BusinessResponse.Status status) {
        this.status = status;
    }

    /**
     * unique id for this search response
     * 
     */
    @JsonProperty("response_id")
    public String getResponseId() {
        return responseId;
    }

    /**
     * unique id for this search response
     * 
     */
    @JsonProperty("response_id")
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    /**
     * business search criteria
     * <p>
     * aggregate criteria information for business search. We expect at least some information is available
     * 
     */
    @JsonProperty("search_criteria")
    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    /**
     * business search criteria
     * <p>
     * aggregate criteria information for business search. We expect at least some information is available
     * 
     */
    @JsonProperty("search_criteria")
    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    /**
     * error content
     * <p>
     * information of common error content
     * 
     */
    @JsonProperty("error_content")
    public ErrorContent getErrorContent() {
        return errorContent;
    }

    /**
     * error content
     * <p>
     * information of common error content
     * 
     */
    @JsonProperty("error_content")
    public void setErrorContent(ErrorContent errorContent) {
        this.errorContent = errorContent;
    }

    /**
     * it will return when response status is success
     * 
     */
    @JsonProperty("results")
    public List<Object> getResults() {
        return results;
    }

    /**
     * it will return when response status is success
     * 
     */
    @JsonProperty("results")
    public void setResults(List<Object> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        SUCCESS("SUCCESS"),
        FAILURE("FAILURE"),
        NO_RESULT("NO_RESULT");
        private final String value;
        private static Map<String, BusinessResponse.Status> constants = new HashMap<String, BusinessResponse.Status>();

        static {
            for (BusinessResponse.Status c: values()) {
                constants.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static BusinessResponse.Status fromValue(String value) {
            BusinessResponse.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
