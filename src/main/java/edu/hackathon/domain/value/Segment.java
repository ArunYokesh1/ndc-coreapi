package edu.hackathon.domain.value;

import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({"flightNumber", "airlineLogo", "depTime", "arrivalTime", "availableAncilaries"})
public class Segment {

    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonProperty("airlineLogo")
    private String airlineLogo;
    @JsonProperty("depTime")
    private String depTime;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
    @JsonProperty("availableAncilaries")
    private List<AvailableAncilaries> availableAncilaries;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return The flightNumber
     */
    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * 
     * @param flightNumber The flightNumber
     */
    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * 
     * @return The airlineLogo
     */
    @JsonProperty("airlineLogo")
    public String getAirlineLogo() {
        return airlineLogo;
    }

    /**
     * 
     * @param airlineLogo The airlineLogo
     */
    @JsonProperty("airlineLogo")
    public void setAirlineLogo(String airlineLogo) {
        this.airlineLogo = airlineLogo;
    }

    /**
     * 
     * @return The depTime
     */
    @JsonProperty("depTime")
    public String getDepTime() {
        return depTime;
    }

    /**
     * 
     * @param depTime The depTime
     */
    @JsonProperty("depTime")
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    /**
     * 
     * @return The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 
     * @param arrivalTime The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * 
     * @return The availableAncilaries
     */
    @JsonProperty("availableAncilaries")
    public List<AvailableAncilaries> getAvailableAncilaries() {
        return availableAncilaries;
    }

    /**
     * 
     * @param availableAncilaries The availableAncilaries
     */
    @JsonProperty("availableAncilaries")
    public void setAvailableAncilaries(List<AvailableAncilaries> availableAncilaries) {
        this.availableAncilaries = availableAncilaries;
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
