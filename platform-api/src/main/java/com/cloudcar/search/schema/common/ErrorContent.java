
package com.cloudcar.search.schema.common;

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
 * error content
 * <p>
 * information of common error content
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "error_code",
    "message"
})
public class ErrorContent {

    /**
     * The enumeration error codes indicate typical failure cases
     * 
     */
    @JsonProperty("error_code")
    private ErrorContent.ErrorCode errorCode;
    /**
     * detail message to explain why there is failure response
     * 
     */
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The enumeration error codes indicate typical failure cases
     * 
     */
    @JsonProperty("error_code")
    public ErrorContent.ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * The enumeration error codes indicate typical failure cases
     * 
     */
    @JsonProperty("error_code")
    public void setErrorCode(ErrorContent.ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * detail message to explain why there is failure response
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * detail message to explain why there is failure response
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
    public static enum ErrorCode {

        ERROR_LOC("ERROR_LOC"),
        BAD_CATEGORY("BAD_CATEGORY"),
        TIME_OUT("TIME_OUT");
        private final String value;
        private static Map<String, ErrorContent.ErrorCode> constants = new HashMap<String, ErrorContent.ErrorCode>();

        static {
            for (ErrorContent.ErrorCode c: values()) {
                constants.put(c.value, c);
            }
        }

        private ErrorCode(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static ErrorContent.ErrorCode fromValue(String value) {
            ErrorContent.ErrorCode constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
