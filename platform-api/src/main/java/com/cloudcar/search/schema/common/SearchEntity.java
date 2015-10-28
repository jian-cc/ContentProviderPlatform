
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
 * search entity
 * <p>
 * Information of entity being searched. We expects at least one alternative information is available
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "title"
})
public class SearchEntity {

    /**
     * unique id for this entity. It is used by cloudcar internally but also can potentially be mapped to provider's entity id
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * The title of this entity. It could be its official business name
     * 
     */
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * unique id for this entity. It is used by cloudcar internally but also can potentially be mapped to provider's entity id
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * unique id for this entity. It is used by cloudcar internally but also can potentially be mapped to provider's entity id
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The title of this entity. It could be its official business name
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The title of this entity. It could be its official business name
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
