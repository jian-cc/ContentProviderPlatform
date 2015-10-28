
package com.cloudcar.search.schema.configuration;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.cloudcar.search.schema.common.ProviderType;
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
 * content provider configuration
 * <p>
 * information of individual content provider
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "identifier",
    "provider_type",
    "message_queue",
    "timeout",
    "defaultError",
    "provider_url",
    "provider_port",
    "provider_endpoint",
    "provider_method",
    "provider_key",
    "provider_product_type",
    "provider_content_type",
    "content_root_key"
})
public class ProviderConfig {

    /**
     * unique identification for this provider. It could be provider's name
     * 
     */
    @JsonProperty("identifier")
    private String identifier;
    /**
     * content type
     * <p>
     * the enum values for types of content CPP support
     * 
     */
    @JsonProperty("provider_type")
    private ProviderType providerType;
    /**
     * The event message this provider will listen, which should be valid on platform
     * 
     */
    @JsonProperty("message_queue")
    private String messageQueue;
    /**
     * the event timeout for this provider's message event. unit is millisecond
     * 
     */
    @JsonProperty("timeout")
    private Double timeout;
    /**
     * Default error message in case there is no specific message available
     * 
     */
    @JsonProperty("defaultError")
    private String defaultError;
    /**
     * url of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_url")
    private String providerUrl;
    /**
     * port number of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_port")
    private String providerPort;
    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_endpoint")
    private String providerEndpoint;
    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_method")
    private ProviderConfig.ProviderMethod providerMethod;
    /**
     * product key of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_key")
    private String providerKey;
    /**
     * product type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_product_type")
    private String providerProductType;
    /**
     * content type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_content_type")
    private String providerContentType;
    /**
     * root key for result list of return json response
     * 
     */
    @JsonProperty("content_root_key")
    private String contentRootKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * unique identification for this provider. It could be provider's name
     * 
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * unique identification for this provider. It could be provider's name
     * 
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * content type
     * <p>
     * the enum values for types of content CPP support
     * 
     */
    @JsonProperty("provider_type")
    public ProviderType getProviderType() {
        return providerType;
    }

    /**
     * content type
     * <p>
     * the enum values for types of content CPP support
     * 
     */
    @JsonProperty("provider_type")
    public void setProviderType(ProviderType providerType) {
        this.providerType = providerType;
    }

    /**
     * The event message this provider will listen, which should be valid on platform
     * 
     */
    @JsonProperty("message_queue")
    public String getMessageQueue() {
        return messageQueue;
    }

    /**
     * The event message this provider will listen, which should be valid on platform
     * 
     */
    @JsonProperty("message_queue")
    public void setMessageQueue(String messageQueue) {
        this.messageQueue = messageQueue;
    }

    /**
     * the event timeout for this provider's message event. unit is millisecond
     * 
     */
    @JsonProperty("timeout")
    public Double getTimeout() {
        return timeout;
    }

    /**
     * the event timeout for this provider's message event. unit is millisecond
     * 
     */
    @JsonProperty("timeout")
    public void setTimeout(Double timeout) {
        this.timeout = timeout;
    }

    /**
     * Default error message in case there is no specific message available
     * 
     */
    @JsonProperty("defaultError")
    public String getDefaultError() {
        return defaultError;
    }

    /**
     * Default error message in case there is no specific message available
     * 
     */
    @JsonProperty("defaultError")
    public void setDefaultError(String defaultError) {
        this.defaultError = defaultError;
    }

    /**
     * url of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_url")
    public String getProviderUrl() {
        return providerUrl;
    }

    /**
     * url of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_url")
    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    /**
     * port number of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_port")
    public String getProviderPort() {
        return providerPort;
    }

    /**
     * port number of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_port")
    public void setProviderPort(String providerPort) {
        this.providerPort = providerPort;
    }

    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_endpoint")
    public String getProviderEndpoint() {
        return providerEndpoint;
    }

    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_endpoint")
    public void setProviderEndpoint(String providerEndpoint) {
        this.providerEndpoint = providerEndpoint;
    }

    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_method")
    public ProviderConfig.ProviderMethod getProviderMethod() {
        return providerMethod;
    }

    /**
     * The relative path of end point for this API
     * 
     */
    @JsonProperty("provider_method")
    public void setProviderMethod(ProviderConfig.ProviderMethod providerMethod) {
        this.providerMethod = providerMethod;
    }

    /**
     * product key of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_key")
    public String getProviderKey() {
        return providerKey;
    }

    /**
     * product key of content provider's API by which we can call to get content
     * 
     */
    @JsonProperty("provider_key")
    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    /**
     * product type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_product_type")
    public String getProviderProductType() {
        return providerProductType;
    }

    /**
     * product type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_product_type")
    public void setProviderProductType(String providerProductType) {
        this.providerProductType = providerProductType;
    }

    /**
     * content type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_content_type")
    public String getProviderContentType() {
        return providerContentType;
    }

    /**
     * content type of content provider's API, such as application/json
     * 
     */
    @JsonProperty("provider_content_type")
    public void setProviderContentType(String providerContentType) {
        this.providerContentType = providerContentType;
    }

    /**
     * root key for result list of return json response
     * 
     */
    @JsonProperty("content_root_key")
    public String getContentRootKey() {
        return contentRootKey;
    }

    /**
     * root key for result list of return json response
     * 
     */
    @JsonProperty("content_root_key")
    public void setContentRootKey(String contentRootKey) {
        this.contentRootKey = contentRootKey;
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
    public static enum ProviderMethod {

        GET("GET"),
        POST("POST");
        private final String value;
        private static Map<String, ProviderConfig.ProviderMethod> constants = new HashMap<String, ProviderConfig.ProviderMethod>();

        static {
            for (ProviderConfig.ProviderMethod c: values()) {
                constants.put(c.value, c);
            }
        }

        private ProviderMethod(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static ProviderConfig.ProviderMethod fromValue(String value) {
            ProviderConfig.ProviderMethod constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
