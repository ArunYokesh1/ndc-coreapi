
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
    "seat",
    "baggage",
    "meal",
    "wifi"
})
public class AvailableAncilaries {

    @JsonProperty("seat")
    private Seat seat;
    @JsonProperty("baggage")
    private Baggage baggage;
    @JsonProperty("meal")
    private Meal meal;
    @JsonProperty("wifi")
    private Wifi wifi;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The seat
     */
    @JsonProperty("seat")
    public Seat getSeat() {
        return seat;
    }

    /**
     * 
     * @param seat
     *     The seat
     */
    @JsonProperty("seat")
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * 
     * @return
     *     The baggage
     */
    @JsonProperty("baggage")
    public Baggage getBaggage() {
        return baggage;
    }

    /**
     * 
     * @param baggage
     *     The baggage
     */
    @JsonProperty("baggage")
    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    /**
     * 
     * @return
     *     The meal
     */
    @JsonProperty("meal")
    public Meal getMeal() {
        return meal;
    }

    /**
     * 
     * @param meal
     *     The meal
     */
    @JsonProperty("meal")
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * 
     * @return
     *     The wifi
     */
    @JsonProperty("wifi")
    public Wifi getWifi() {
        return wifi;
    }

    /**
     * 
     * @param wifi
     *     The wifi
     */
    @JsonProperty("wifi")
    public void setWifi(Wifi wifi) {
        this.wifi = wifi;
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
