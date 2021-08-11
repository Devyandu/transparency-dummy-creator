
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
    "reporting_entity_name",
    "reporting_entity_type",
    "plan_name",
    "plan_id_type",
    "plan_id",
    "plan_market_type",
    "last_updated_on",
    "in_network"
})
public class Example {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_name")
    private String reportingEntityName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_type")
    private String reportingEntityType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_name")
    private String planName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id_type")
    private String planIdType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    private String planId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_market_type")
    private Example.PlanMarketType planMarketType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("last_updated_on")
    private String lastUpdatedOn;
    @JsonProperty("in_network")
    private List<InNetwork> inNetwork = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_name")
    public String getReportingEntityName() {
        return reportingEntityName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_name")
    public void setReportingEntityName(String reportingEntityName) {
        this.reportingEntityName = reportingEntityName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_type")
    public String getReportingEntityType() {
        return reportingEntityType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reporting_entity_type")
    public void setReportingEntityType(String reportingEntityType) {
        this.reportingEntityType = reportingEntityType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_name")
    public String getPlanName() {
        return planName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_name")
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id_type")
    public String getPlanIdType() {
        return planIdType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id_type")
    public void setPlanIdType(String planIdType) {
        this.planIdType = planIdType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    public String getPlanId() {
        return planId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_market_type")
    public Example.PlanMarketType getPlanMarketType() {
        return planMarketType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("plan_market_type")
    public void setPlanMarketType(Example.PlanMarketType planMarketType) {
        this.planMarketType = planMarketType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("last_updated_on")
    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("last_updated_on")
    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @JsonProperty("in_network")
    public List<InNetwork> getInNetwork() {
        return inNetwork;
    }

    @JsonProperty("in_network")
    public void setInNetwork(List<InNetwork> inNetwork) {
        this.inNetwork = inNetwork;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum PlanMarketType {

        GROUP("group"),
        INDIVIDUAL("individual");
        private final String value;
        private final static Map<String, Example.PlanMarketType> CONSTANTS = new HashMap<String, Example.PlanMarketType>();

        static {
            for (Example.PlanMarketType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        PlanMarketType(String value) {
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
        public static Example.PlanMarketType fromValue(String value) {
            Example.PlanMarketType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
