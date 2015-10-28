
package com.cloudcar.search.schema.business;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * daily business hour
 * <p>
 * information of business hour for a single day
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "is_open",
    "start",
    "end"
})
public class DailyBusinessHour {

    @JsonProperty("is_open")
    private DailyBusinessHour.IsOpen isOpen;
    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("start")
    private String start;
    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("end")
    private String end;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("is_open")
    public DailyBusinessHour.IsOpen getIsOpen() {
        return isOpen;
    }

    @JsonProperty("is_open")
    public void setIsOpen(DailyBusinessHour.IsOpen isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * time
     * <p>
     * special format for time string. It has format as hh:mm
     * 
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
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
    public static enum IsOpen {

        YES("yes"),
        NO("no"),
        UNKNOWN("unknown");
        private final String value;
        private static Map<String, DailyBusinessHour.IsOpen> constants = new HashMap<String, DailyBusinessHour.IsOpen>();

        static {
            for (DailyBusinessHour.IsOpen c: values()) {
                constants.put(c.value, c);
            }
        }

        private IsOpen(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static DailyBusinessHour.IsOpen fromValue(String value) {
            DailyBusinessHour.IsOpen constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
