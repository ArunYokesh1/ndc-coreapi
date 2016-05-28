package edu.hackathon.domain.value;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"ancillaryName", "ancillaryType", "ancillaryUrl"})
public class AvailableAncilaries {

    @JsonProperty("ancillaryName")
    private String ancillaryName;
    @JsonProperty("ancillaryType")
    private String ancillaryType;
    @JsonProperty("ancillaryUrl")
    private String ancillaryUrl;

    /**
     * @return the ancillaryName
     */
    public String getAncillaryName() {
        return ancillaryName;
    }

    /**
     * @param ancillaryName the ancillaryName to set
     */
    public void setAncillaryName(String ancillaryName) {
        this.ancillaryName = ancillaryName;
    }

    /**
     * @return the ancillaryType
     */
    public String getAncillaryType() {
        return ancillaryType;
    }

    /**
     * @param ancillaryType the ancillaryType to set
     */
    public void setAncillaryType(String ancillaryType) {
        this.ancillaryType = ancillaryType;
    }

    /**
     * @return the ancillaryUrl
     */
    public String getAncillaryUrl() {
        return ancillaryUrl;
    }

    /**
     * @param ancillaryUrl the ancillaryUrl to set
     */
    public void setAncillaryUrl(String ancillaryUrl) {
        this.ancillaryUrl = ancillaryUrl;
    }

}
