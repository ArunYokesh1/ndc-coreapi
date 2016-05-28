
package edu.hackathon.domain.value;

import java.util.ArrayList;
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
@JsonPropertyOrder({
    "orgin",
    "destination",
    "meeting",
    "recomendedItinerary",
    "otherItineraries"
})
public class Offers {

    @JsonProperty("orgin")
    private String orgin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("meeting")
    private Meeting meeting;
    @JsonProperty("recommendedItinerary")
    private RecommendedItinerary recommendedItinerary;
    @JsonProperty("otherItineraries")
    private List<Itinerary> otherItineraries = new ArrayList<>();
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The orgin
     */
    @JsonProperty("orgin")
    public String getOrgin() {
        return orgin;
    }

    /**
     * 
     * @param orgin
     *     The orgin
     */
    @JsonProperty("orgin")
    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }

    /**
     * 
     * @return
     *     The destination
     */
    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    /**
     * 
     * @param destination
     *     The destination
     */
    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * 
     * @return
     *     The meeting
     */
    @JsonProperty("meeting")
    public Meeting getMeeting() {
        return meeting;
    }

    /**
     * 
     * @param meeting
     *     The meeting
     */
    @JsonProperty("meeting")
    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    /**
     * 
     * @return
     *     The recomendedItinerary
     */
    @JsonProperty("recomendedItinerary")
    public RecommendedItinerary getRecommendedItinerary() {
        return recommendedItinerary;
    }

    /**
     * 
     * @param recomendedItinerary
     *     The recomendedItinerary
     */
    @JsonProperty("recomendedItinerary")
    public void setRecommendedItinerary(RecommendedItinerary recomendedItinerary) {
        this.recommendedItinerary = recomendedItinerary;
    }

    /**
     * 
     * @return
     *     The otherItineraries
     */
    @JsonProperty("otherItineraries")
    public List<Itinerary> getOtherItineraries() {
        return otherItineraries;
    }

    /**
     * 
     * @param otherItineraries
     *     The otherItineraries
     */
    @JsonProperty("otherItineraries")
    public void setOtherItineraries(List<Itinerary> otherItineraries) {
        this.otherItineraries = otherItineraries;
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
