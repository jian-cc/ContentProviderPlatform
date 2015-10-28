
package com.cloudcar.search.schema.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.cloudcar.search.interfaces.SearchResult;
import com.cloudcar.search.schema.common.Contact;
import com.cloudcar.search.schema.common.Location;
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
 * business search result
 * <p>
 * information of search result for a single business entity.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "location",
    "id",
    "title",
    "contact",
    "business_time",
    "icon",
    "type",
    "category",
    "provider_detail"
})
public class BusinessSearchResult implements SearchResult
{

    /**
     * location
     * <p>
     * combination information regarding to location. it has three alternative sources, locationId, geocode, and real address. It also include radius information for that location
     * 
     */
    @JsonProperty("location")
    private Location location;
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    /**
     * contact
     * <p>
     * common contact information.
     * 
     */
    @JsonProperty("contact")
    private Contact contact;
    /**
     * request of business/location search request
     * 
     */
    @JsonProperty("business_time")
    private BusinessTime businessTime;
    /**
     * information of icon url
     * 
     */
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("type")
    private List<String> type = new ArrayList<String>();
    @JsonProperty("category")
    private List<String> category = new ArrayList<String>();
    /**
     * this is undefined json object
     * 
     */
    @JsonProperty("provider_detail")
    private List<Object> providerDetail = new ArrayList<Object>();
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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * contact
     * <p>
     * common contact information.
     * 
     */
    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    /**
     * contact
     * <p>
     * common contact information.
     * 
     */
    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * request of business/location search request
     * 
     */
    @JsonProperty("business_time")
    public BusinessTime getBusinessTime() {
        return businessTime;
    }

    /**
     * request of business/location search request
     * 
     */
    @JsonProperty("business_time")
    public void setBusinessTime(BusinessTime businessTime) {
        this.businessTime = businessTime;
    }

    /**
     * information of icon url
     * 
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * information of icon url
     * 
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("type")
    public List<String> getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(List<String> type) {
        this.type = type;
    }

    @JsonProperty("category")
    public List<String> getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(List<String> category) {
        this.category = category;
    }

    /**
     * this is undefined json object
     * 
     */
    @JsonProperty("provider_detail")
    public List<Object> getProviderDetail() {
        return providerDetail;
    }

    /**
     * this is undefined json object
     * 
     */
    @JsonProperty("provider_detail")
    public void setProviderDetail(List<Object> providerDetail) {
        this.providerDetail = providerDetail;
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
