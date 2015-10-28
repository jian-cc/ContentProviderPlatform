
package com.cloudcar.search.schema.common;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * provider detail
 * <p>
 * information of a search result from a single provider
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "provider",
    "result"
})
public class ProviderDetail {

    /**
     * provider identification, it could be a provider's name, its id, or anything provider want to use to identify itself
     * 
     */
    @JsonProperty("provider")
    private String provider;
    /**
     * the detail result from this provider. Beware, this is undefined-type object, a same provider may give different format of result for different search type
     * 
     */
    @JsonProperty("result")
    private Result result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * provider identification, it could be a provider's name, its id, or anything provider want to use to identify itself
     * 
     */
    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    /**
     * provider identification, it could be a provider's name, its id, or anything provider want to use to identify itself
     * 
     */
    @JsonProperty("provider")
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * the detail result from this provider. Beware, this is undefined-type object, a same provider may give different format of result for different search type
     * 
     */
    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    /**
     * the detail result from this provider. Beware, this is undefined-type object, a same provider may give different format of result for different search type
     * 
     */
    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
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

}
