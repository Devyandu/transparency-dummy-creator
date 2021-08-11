
package com.example;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "negotiated_type",
    "negotiated_rate",
    "expiration_date"
})
public class NegotiatedPrice {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_type")
    private NegotiatedPrice.NegotiatedType negotiatedType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rate")
    private Double negotiatedRate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_type")
    public NegotiatedPrice.NegotiatedType getNegotiatedType() {
        return negotiatedType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_type")
    public void setNegotiatedType(NegotiatedPrice.NegotiatedType negotiatedType) {
        this.negotiatedType = negotiatedType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rate")
    public Double getNegotiatedRate() {
        return negotiatedRate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rate")
    public void setNegotiatedRate(Double negotiatedRate) {
        this.negotiatedRate = negotiatedRate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiration_date")
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiration_date")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum NegotiatedType {

        NEGOTIATED("negotiated"),
        DERIVED("derived"),
        FEE_SCHEDULE("fee schedule");
        private final String value;
        private final static Map<String, NegotiatedPrice.NegotiatedType> CONSTANTS = new HashMap<String, NegotiatedPrice.NegotiatedType>();

        static {
            for (NegotiatedPrice.NegotiatedType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        NegotiatedType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static NegotiatedPrice.NegotiatedType fromValue(String value) {
            NegotiatedPrice.NegotiatedType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
