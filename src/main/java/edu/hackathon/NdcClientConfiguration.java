/**
 * 
 */
package edu.hackathon;

import org.iata.ndc.NdcClient;

import edu.hackathon.util.ApplicationConstants;

/**
 * @author Jayaprabahar
 *
 */
public abstract class NdcClientConfiguration {

    public static NdcClient getNdcClient() {
        return new NdcClient(ApplicationConstants.ENDPOINT_IATA_MASHERY_ATHENA, ApplicationConstants.USERKEY_IATA_MASHERY_ATHENA);
    }
}
