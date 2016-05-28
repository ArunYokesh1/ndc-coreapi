
package edu.hackathon.domain.value;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "segments",
    "reasonForRecomendation"
})
public class RecommendedItinerary extends Itinerary {

    @JsonProperty("reasonForRecomendation")
    private String reasonForRecomendation;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The reasonForRecomendation
     */
    @JsonProperty("reasonForRecomendation")
    public String getReasonForRecomendation() {
        return reasonForRecomendation;
    }

    /**
     * 
     * @param reasonForRecomendation
     *     The reasonForRecomendation
     */
    @JsonProperty("reasonForRecomendation")
    public void setReasonForRecomendation(String reasonForRecomendation) {
        this.reasonForRecomendation = reasonForRecomendation;
    }

    @Override
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
