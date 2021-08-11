package entities;

import com.example.Example;
import com.example.InNetwork;
import com.example.NegotiatedPrice;
import com.example.NegotiatedRates;

import org.apache.commons.lang.ArrayUtils;

public class FlatEntity {

    private String reporting_entity_name, reporting_entity_type, plan_name, plan_id_type, plan_id, plan_market_type, 
    last_updated_on;
    private String negotiation_arrangement, name, billing_code_type, billing_code_type_version, billing_code, description;
    private String providers, tin, service_code;
    private String negotiated_type, negotiated_rate, expiration_date;
    public static FlatEntity factory(Example plan, InNetwork inNetwork, NegotiatedRates nr ,NegotiatedPrice np){
        FlatEntity fe = new FlatEntity();
        fe.setReporting_entity_name(plan.getReportingEntityName());
        fe.setReporting_entity_type(plan.getReportingEntityType());
        fe.setPlan_name(plan.getPlanName());
        fe.setPlan_id_type(plan.getPlanIdType());
        fe.setPlan_id(plan.getPlanId());
        fe.setPlan_market_type(plan.getPlanMarketType().value());
        fe.setLast_updated_on(plan.getLastUpdatedOn());

        fe.setNegotiation_arrangement(inNetwork.getNegotiationArrangement().value());
        fe.setName(inNetwork.getName());
        fe.setBilling_code_type(inNetwork.getBillingCodeType().value());
        fe.setBilling_code_type_version(inNetwork.getBillingCodeTypeVersion());
        fe.setBilling_code(inNetwork.getBillingCode());
        fe.setDescription(inNetwork.getDescription());
        String providerResult="";
        for (Double pi:nr.getProviders())
        {
            if (providerResult.length()==0)
            {
                providerResult=String.valueOf(pi);
            }else{
                providerResult=providerResult+","+pi;
            }
            
        }
        fe.setProviders(providerResult);        fe.setTin(nr.getTin());        fe.setService_code(nr.getServiceCode().toString());
        fe.setNegotiated_type(np.getNegotiatedType().value());
        fe.setNegotiated_rate(np.getNegotiatedRate().toString());
        fe.setExpiration_date(np.getExpirationDate());
        return fe;
    } 

    private FlatEntity() {
    }

    public String getReporting_entity_name() {
        return reporting_entity_name;
    }
    public void setReporting_entity_name(String reporting_entity_name) {
        this.reporting_entity_name = reporting_entity_name;
    }
    public String getReporting_entity_type() {
        return reporting_entity_type;
    }
    public void setReporting_entity_type(String reporting_entity_type) {
        this.reporting_entity_type = reporting_entity_type;
    }
    public String getPlan_name() {
        return plan_name;
    }
    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }
    public String getPlan_id_type() {
        return plan_id_type;
    }
    public void setPlan_id_type(String plan_id_type) {
        this.plan_id_type = plan_id_type;
    }
    public String getPlan_id() {
        return plan_id;
    }
    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }
    public String getPlan_market_type() {
        return plan_market_type;
    }
    public void setPlan_market_type(String plan_market_type) {
        this.plan_market_type = plan_market_type;
    }
    public String getLast_updated_on() {
        return last_updated_on;
    }
    public void setLast_updated_on(String last_updated_on) {
        this.last_updated_on = last_updated_on;
    }
    public String getNegotiation_arrangement() {
        return negotiation_arrangement;
    }
    public void setNegotiation_arrangement(String negotiation_arrangement) {
        this.negotiation_arrangement = negotiation_arrangement;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBilling_code_type() {
        return billing_code_type;
    }
    public void setBilling_code_type(String billing_code_type) {
        this.billing_code_type = billing_code_type;
    }
    public String getBilling_code_type_version() {
        return billing_code_type_version;
    }
    public void setBilling_code_type_version(String billing_code_type_version) {
        this.billing_code_type_version = billing_code_type_version;
    }
    public String getBilling_code() {
        return billing_code;
    }
    public void setBilling_code(String billing_code) {
        this.billing_code = billing_code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProviders() {
        return providers;
    }
    public void setProviders(String providers) {
        this.providers = providers;
    }
    public String getTin() {
        return tin;
    }
    public void setTin(String tin) {
        this.tin = tin;
    }
    public String getService_code() {
        return service_code;
    }
    public void setService_code(String service_code) {
        this.service_code = service_code;
    }
    public String getNegotiated_type() {
        return negotiated_type;
    }
    public void setNegotiated_type(String negotiated_type) {
        this.negotiated_type = negotiated_type;
    }
    public String getNegotiated_rate() {
        return negotiated_rate;
    }
    public void setNegotiated_rate(String negotiated_rate) {
        this.negotiated_rate = negotiated_rate;
    }
    public String getExpiration_date() {
        return expiration_date;
    }
    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }
    
    
}
