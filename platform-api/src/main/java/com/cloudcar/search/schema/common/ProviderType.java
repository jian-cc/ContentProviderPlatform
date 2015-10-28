
package com.cloudcar.search.schema.common;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Generated("org.jsonschema2pojo")
public enum ProviderType {

    BUSINESS("BUSINESS"),
    PLACE("PLACE"),
    WEATHER("WEATHER");
    private final String value;
    private static Map<String, ProviderType> constants = new HashMap<String, ProviderType>();

    static {
        for (ProviderType c: values()) {
            constants.put(c.value, c);
        }
    }

    private ProviderType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }

    @JsonCreator
    public static ProviderType fromValue(String value) {
        ProviderType constant = constants.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
