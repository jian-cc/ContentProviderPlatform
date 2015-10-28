
package com.cloudcar.search.schema.business;

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
 * request of business/location search request
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "open_now",
    "monday",
    "tuesday",
    "wednesday",
    "thursday",
    "friday",
    "saturday",
    "sunday"
})
public class BusinessTime {

    @JsonProperty("open_now")
    private Boolean openNow;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("monday")
    private DailyBusinessHour monday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("tuesday")
    private DailyBusinessHour tuesday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("wednesday")
    private DailyBusinessHour wednesday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("thursday")
    private DailyBusinessHour thursday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("friday")
    private DailyBusinessHour friday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("saturday")
    private DailyBusinessHour saturday;
    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("sunday")
    private DailyBusinessHour sunday;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("open_now")
    public Boolean getOpenNow() {
        return openNow;
    }

    @JsonProperty("open_now")
    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("monday")
    public DailyBusinessHour getMonday() {
        return monday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("monday")
    public void setMonday(DailyBusinessHour monday) {
        this.monday = monday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("tuesday")
    public DailyBusinessHour getTuesday() {
        return tuesday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("tuesday")
    public void setTuesday(DailyBusinessHour tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("wednesday")
    public DailyBusinessHour getWednesday() {
        return wednesday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("wednesday")
    public void setWednesday(DailyBusinessHour wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("thursday")
    public DailyBusinessHour getThursday() {
        return thursday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("thursday")
    public void setThursday(DailyBusinessHour thursday) {
        this.thursday = thursday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("friday")
    public DailyBusinessHour getFriday() {
        return friday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("friday")
    public void setFriday(DailyBusinessHour friday) {
        this.friday = friday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("saturday")
    public DailyBusinessHour getSaturday() {
        return saturday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("saturday")
    public void setSaturday(DailyBusinessHour saturday) {
        this.saturday = saturday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("sunday")
    public DailyBusinessHour getSunday() {
        return sunday;
    }

    /**
     * daily business hour
     * <p>
     * information of business hour for a single day
     * 
     */
    @JsonProperty("sunday")
    public void setSunday(DailyBusinessHour sunday) {
        this.sunday = sunday;
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
