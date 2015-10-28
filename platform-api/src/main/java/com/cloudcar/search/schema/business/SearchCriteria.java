
package com.cloudcar.search.schema.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.cloudcar.search.schema.common.Location;
import com.cloudcar.search.schema.common.SearchEntity;
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
 * business search criteria
 * <p>
 * aggregate criteria information for business search. We expect at least some information is available
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "location",
    "business_entity",
    "type",
    "category",
    "flavor",
    "timing"
})
public class SearchCriteria {

    /**
     * location
     * <p>
     * combination information regarding to location. it has three alternative sources, locationId, geocode, and real address. It also include radius information for that location
     * 
     */
    @JsonProperty("location")
    private Location location;
    /**
     * search entity
     * <p>
     * Information of entity being searched. We expects at least one alternative information is available
     * 
     */
    @JsonProperty("business_entity")
    private SearchEntity businessEntity;
    /**
     * the type of business, such as Hotel, Food, etc. We support multi-types search
     * 
     */
    @JsonProperty("type")
    private List<String> type = new ArrayList<String>();
    /**
     * the category of business, such as restaurant, discount store, etc. We support multi-categories search
     * 
     */
    @JsonProperty("category")
    private List<String> category = new ArrayList<String>();
    /**
     * the special narrow down for category, such as Chinese restaurant, toy discount store, etc.
     * 
     */
    @JsonProperty("flavor")
    private List<String> flavor = new ArrayList<String>();
    /**
     * date time
     * <p>
     * special format for date-time string. It has format as yyyy-mm-dd hh:mm
     * 
     */
    @JsonProperty("timing")
    private String timing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * location
     * <p>
     * combination information regarding to location. it has three alternative sources, locationId, geocode, and real address. It also include radius information for that location
     * 
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * location
     * <p>
     * combination information regarding to location. it has three alternative sources, locationId, geocode, and real address. It also include radius information for that location
     * 
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * search entity
     * <p>
     * Information of entity being searched. We expects at least one alternative information is available
     * 
     */
    @JsonProperty("business_entity")
    public SearchEntity getBusinessEntity() {
        return businessEntity;
    }

    /**
     * search entity
     * <p>
     * Information of entity being searched. We expects at least one alternative information is available
     * 
     */
    @JsonProperty("business_entity")
    public void setBusinessEntity(SearchEntity businessEntity) {
        this.businessEntity = businessEntity;
    }

    /**
     * the type of business, such as Hotel, Food, etc. We support multi-types search
     * 
     */
    @JsonProperty("type")
    public List<String> getType() {
        return type;
    }

    /**
     * the type of business, such as Hotel, Food, etc. We support multi-types search
     * 
     */
    @JsonProperty("type")
    public void setType(List<String> type) {
        this.type = type;
    }

    /**
     * the category of business, such as restaurant, discount store, etc. We support multi-categories search
     * 
     */
    @JsonProperty("category")
    public List<String> getCategory() {
        return category;
    }

    /**
     * the category of business, such as restaurant, discount store, etc. We support multi-categories search
     * 
     */
    @JsonProperty("category")
    public void setCategory(List<String> category) {
        this.category = category;
    }

    /**
     * the special narrow down for category, such as Chinese restaurant, toy discount store, etc.
     * 
     */
    @JsonProperty("flavor")
    public List<String> getFlavor() {
        return flavor;
    }

    /**
     * the special narrow down for category, such as Chinese restaurant, toy discount store, etc.
     * 
     */
    @JsonProperty("flavor")
    public void setFlavor(List<String> flavor) {
        this.flavor = flavor;
    }

    /**
     * date time
     * <p>
     * special format for date-time string. It has format as yyyy-mm-dd hh:mm
     * 
     */
    @JsonProperty("timing")
    public String getTiming() {
        return timing;
    }

    /**
     * date time
     * <p>
     * special format for date-time string. It has format as yyyy-mm-dd hh:mm
     * 
     */
    @JsonProperty("timing")
    public void setTiming(String timing) {
        this.timing = timing;
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
