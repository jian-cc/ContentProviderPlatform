
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
 * location
 * <p>
 * combination information regarding to location. it has three alternative sources, locationId, geocode, and real address. It also include radius information for that location
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "locationId",
    "geocode",
    "address",
    "radius"
})
public class Location {

    /**
     * It is a unique id to represent a real address or geocode. In general, it is used by cloudcar internally. It can also map to a provider's location id if it is allowed
     * 
     */
    @JsonProperty("locationId")
    private String locationId;
    /**
     * geocode
     * <p>
     * Standard geocode information.
     * 
     */
    @JsonProperty("geocode")
    private Geocode geocode;
    /**
     * address
     * <p>
     * common address information.
     * 
     */
    @JsonProperty("address")
    private Address address;
    /**
     * default unit is mile
     * 
     */
    @JsonProperty("radius")
    private Double radius;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * It is a unique id to represent a real address or geocode. In general, it is used by cloudcar internally. It can also map to a provider's location id if it is allowed
     * 
     */
    @JsonProperty("locationId")
    public String getLocationId() {
        return locationId;
    }

    /**
     * It is a unique id to represent a real address or geocode. In general, it is used by cloudcar internally. It can also map to a provider's location id if it is allowed
     * 
     */
    @JsonProperty("locationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * geocode
     * <p>
     * Standard geocode information.
     * 
     */
    @JsonProperty("geocode")
    public Geocode getGeocode() {
        return geocode;
    }

    /**
     * geocode
     * <p>
     * Standard geocode information.
     * 
     */
    @JsonProperty("geocode")
    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    /**
     * address
     * <p>
     * common address information.
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * address
     * <p>
     * common address information.
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * default unit is mile
     * 
     */
    @JsonProperty("radius")
    public Double getRadius() {
        return radius;
    }

    /**
     * default unit is mile
     * 
     */
    @JsonProperty("radius")
    public void setRadius(Double radius) {
        this.radius = radius;
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
