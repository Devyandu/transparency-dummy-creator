
package com.example;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "billing_code_type",
    "billing_code_type_version",
    "billing_code",
    "description"
})
public class CoveredServices {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    private String billingCodeType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type_version")
    private String billingCodeTypeVersion;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code")
    private String billingCode;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    public String getBillingCodeType() {
        return billingCodeType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    public void setBillingCodeType(String billingCodeType) {
        this.billingCodeType = billingCodeType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type_version")
    public String getBillingCodeTypeVersion() {
        return billingCodeTypeVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type_version")
    public void setBillingCodeTypeVersion(String billingCodeTypeVersion) {
        this.billingCodeTypeVersion = billingCodeTypeVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code")
    public String getBillingCode() {
        return billingCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code")
    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
