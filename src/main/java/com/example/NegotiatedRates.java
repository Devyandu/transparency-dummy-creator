
package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "providers",
    "tin",
    "service_code",
    "negotiated_price"
})
public class NegotiatedRates {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("providers")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<Double> providers = null;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tin")
    private String tin;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("service_code")
    private Object serviceCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_price")
    private NegotiatedPrice negotiatedPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("providers")
    public Set<Double> getProviders() {
        return providers;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("providers")
    public void setProviders(Set<Double> providers) {
        this.providers = providers;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tin")
    public String getTin() {
        return tin;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("tin")
    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("service_code")
    public Object getServiceCode() {
        return serviceCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("service_code")
    public void setServiceCode(Object serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_price")
    public NegotiatedPrice getNegotiatedPrice() {
        return negotiatedPrice;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_price")
    public void setNegotiatedPrice(NegotiatedPrice negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
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
