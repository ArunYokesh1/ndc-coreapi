
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
    "segments"
})
public class Itinerary {

    @JsonProperty("segments")
    private List<Segment> segments = new ArrayList<>();
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The segments
     */
    @JsonProperty("segments")
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * 
     * @param segments
     *     The segments
     */
    @JsonProperty("segments")
    public void setSegments(List<Segment> segments) {
        this.segments = segments;
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
