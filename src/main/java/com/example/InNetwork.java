
package com.example;

import java.util.HashMap;
import java.util.List;
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
    "negotiation_arrangement",
    "name",
    "billing_code_type",
    "billing_code_type_version",
    "billing_code",
    "description",
    "negotiated_rates",
    "covered_services",
    "bundled_codes"
})
public class InNetwork {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiation_arrangement")
    private InNetwork.NegotiationArrangement negotiationArrangement;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    private InNetwork.BillingCodeType billingCodeType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type_version")
    private String billingCodeTypeVersion;
    @JsonProperty("billing_code")
    private String billingCode;
    @JsonProperty("description")
    private String description;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rates")
    private List<NegotiatedRates> negotiatedRates = null;
    @JsonProperty("covered_services")
    private List<CoveredServices> coveredServices = null;
    @JsonProperty("bundled_codes")
    private List<BundledCodes> bundledCodes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiation_arrangement")
    public InNetwork.NegotiationArrangement getNegotiationArrangement() {
        return negotiationArrangement;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiation_arrangement")
    public void setNegotiationArrangement(InNetwork.NegotiationArrangement negotiationArrangement) {
        this.negotiationArrangement = negotiationArrangement;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    public InNetwork.BillingCodeType getBillingCodeType() {
        return billingCodeType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("billing_code_type")
    public void setBillingCodeType(InNetwork.BillingCodeType billingCodeType) {
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

    @JsonProperty("billing_code")
    public String getBillingCode() {
        return billingCode;
    }

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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rates")
    public List<NegotiatedRates> getNegotiatedRates() {
        return negotiatedRates;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("negotiated_rates")
    public void setNegotiatedRates(List<NegotiatedRates> negotiatedRates) {
        this.negotiatedRates = negotiatedRates;
    }

    @JsonProperty("covered_services")
    public List<CoveredServices> getCoveredServices() {
        return coveredServices;
    }

    @JsonProperty("covered_services")
    public void setCoveredServices(List<CoveredServices> coveredServices) {
        this.coveredServices = coveredServices;
    }

    @JsonProperty("bundled_codes")
    public List<BundledCodes> getBundledCodes() {
        return bundledCodes;
    }

    @JsonProperty("bundled_codes")
    public void setBundledCodes(List<BundledCodes> bundledCodes) {
        this.bundledCodes = bundledCodes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum BillingCodeType {

        CPT("CPT"),
        HCPCS("HCPCS"),
        ICD("ICD"),
        MS_DRG("MS-DRG"),
        R_DRG("R-DRG"),
        S_DRG("S-DRG"),
        APS_DRG("APS-DRG"),
        AP_DRG("AP-DRG"),
        APR_DRG("APR-DRG"),
        APC("APC"),
        NDC("NDC"),
        HIPPS("HIPPS"),
        LOCAL("LOCAL"),
        EAPG("EAPG"),
        CDT("CDT");
        private final String value;
        private final static Map<String, InNetwork.BillingCodeType> CONSTANTS = new HashMap<String, InNetwork.BillingCodeType>();

        static {
            for (InNetwork.BillingCodeType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        BillingCodeType(String value) {
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
        public static InNetwork.BillingCodeType fromValue(String value) {
            InNetwork.BillingCodeType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum NegotiationArrangement {

        FFS("ffs"),
        BUNDLE("bundle"),
        CAPITATION("capitation");
        private final String value;
        private final static Map<String, InNetwork.NegotiationArrangement> CONSTANTS = new HashMap<String, InNetwork.NegotiationArrangement>();

        static {
            for (InNetwork.NegotiationArrangement c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        NegotiationArrangement(String value) {
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
        public static InNetwork.NegotiationArrangement fromValue(String value) {
            InNetwork.NegotiationArrangement constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
