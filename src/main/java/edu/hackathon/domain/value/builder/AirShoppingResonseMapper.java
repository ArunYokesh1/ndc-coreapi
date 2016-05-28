/**
 * 
 */
package edu.hackathon.domain.value.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iata.ndc.schema.AirShoppingRS;
import org.iata.ndc.schema.AirShoppingRS.DataLists;
import org.iata.ndc.schema.AirShoppingRS.OffersGroup;
import org.iata.ndc.schema.AirShoppingRS.OffersGroup.AirlineOffers.AirlineOffer;
import org.iata.ndc.schema.DataListType.Flight;
import org.iata.ndc.schema.ListOfFlightSegmentType;
import org.iata.ndc.schema.OriginDestination;
import org.iata.ndc.schema.ServiceDetailType;

import edu.hackathon.domain.value.AvailableAncilaries;
import edu.hackathon.domain.value.Offers;
import edu.hackathon.domain.value.RecommendedItinerary;
import edu.hackathon.domain.value.Segment;
import edu.hackathon.util.ApplicationConstants;

/**
 * @author Jayaprabahar
 *
 */
public class AirShoppingResonseMapper {

    public Offers mapAirShoppingResponse(AirShoppingRS response) {
        Offers offers = new Offers();

        DataLists dataLists = response.getDataLists();

        List<Flight> flightList = dataLists.getFlightList();
        List<ListOfFlightSegmentType> segmentList = dataLists.getFlightSegmentList();
        List<ServiceDetailType> ancilaryList = dataLists.getServiceList();
        OffersGroup offersGroup = response.getOffersGroup();

        Map<String, String> ancilaryServicesLookupMap = getAncilaryServicesLookup(ancilaryList);
        Map<String, List<Object>> flightAncilariesLookup = getFlightAncilariesLookup(offersGroup.getAirlineOffers().get(0).getAirlineOffer());

        OriginDestination originDestination = dataLists.getOriginDestinationList().get(0);
        // TODO - UI will add values here
        offers.setMeeting(null);
        offers.setOrgin(originDestination.getDepartureCode().getValue());
        offers.setDestination(originDestination.getArrivalCode().getValue());

        RecommendedItinerary recomendedItinerary = identifyRecommendedItinerary(flightList.get(0), segmentList, flightAncilariesLookup, ancilaryServicesLookupMap);
        offers.setRecommendedItinerary(recomendedItinerary);

        return offers;
    }

    private Map<String, String> getAncilaryServicesLookup(List<ServiceDetailType> ancilaryList) {
        Map<String, String> ancilaryServicesLookup = new HashMap<String, String>();
        for (ServiceDetailType serviceDetailType : ancilaryList) {
            ancilaryServicesLookup.put(serviceDetailType.getObjectKey(), serviceDetailType.getName().getValue());
        }
        return ancilaryServicesLookup;
    }

    private Map<String, List<Object>> getFlightAncilariesLookup(List<AirlineOffer> airlineOffers) {
        Map<String, List<Object>> flightAncilariesLookup = new HashMap<String, List<Object>>();
        for (AirlineOffer airlineOffer : airlineOffers) {
            flightAncilariesLookup.put(airlineOffer.getPricedOffer().getAssociations().get(0).getApplicableFlight().getFlightReferences().toString(), airlineOffer.getPricedOffer().getAssociations().get(0)
                            .getAssociatedService().getServiceReferences());
        }
        return flightAncilariesLookup;
    }

    private RecommendedItinerary identifyRecommendedItinerary(Flight singleFlight, List<ListOfFlightSegmentType> flightSegmentList, Map<String, List<Object>> flightAncilariesLookup,
                    Map<String, String> ancilaryServicesLookupMap) {
        RecommendedItinerary recomendedItinerary = new RecommendedItinerary();
        recomendedItinerary.setReasonForRecomendation(ApplicationConstants.RECOMMENDED_FLT_REASON_1);
        List<Segment> segments = new ArrayList<Segment>();

        Segment segment = new Segment();
        segment = mapFlightSegments(singleFlight, flightSegmentList);

        List<Object> includedAncilaries = flightAncilariesLookup.get(singleFlight);
        for (Object object : includedAncilaries) {
            AvailableAncilaries ancilaries = new AvailableAncilaries();
            ancilaries.setAncillaryName(ancilaryServicesLookupMap.get(object.toString()));
            // ancilaries.setAncillaryType(ancilaries.getAncillaryName().matches(regex));
            ancilaries.setAncillaryUrl(ancilaryServicesLookupMap.get(object.toString()));
        }

        List<AvailableAncilaries> availableAncilaries = new ArrayList<AvailableAncilaries>();
        segment.setAvailableAncilaries(availableAncilaries);

        segments.add(segment);
        recomendedItinerary.setSegments(segments);
        return recomendedItinerary;
    }

    private Segment mapFlightSegments(Flight singleFlight, List<ListOfFlightSegmentType> flightSegmentList) {
        String segmentId = singleFlight.getSegmentReferences().toString();
        Segment segment = new Segment();
        segment.setFlightNumber(singleFlight.getFlightKey());
        segment.setAirlineLogo(null);

        for (ListOfFlightSegmentType listOfFlightSegmentType : flightSegmentList) {
            if (listOfFlightSegmentType.getSegmentKey().equalsIgnoreCase(segmentId)) {
                segment.setDepTime(listOfFlightSegmentType.getDeparture().getTime());
                segment.setArrivalTime(listOfFlightSegmentType.getArrival().getTime());
                break;
            }
        }
        return segment;
    }

}
