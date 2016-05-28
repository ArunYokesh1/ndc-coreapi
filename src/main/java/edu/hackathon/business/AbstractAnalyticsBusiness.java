package edu.hackathon.business;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.repository.model.Order;
import edu.hackathon.repository.model.Passenger;
import edu.hackathon.repository.model.PassengerSegment;
import edu.hackathon.repository.model.Product;
import edu.hackathon.rest.domain.AbstractAnalyticsItem;
import edu.hackathon.rest.domain.Price;

public abstract class AbstractAnalyticsBusiness {

	public <T extends AbstractAnalyticsItem> void setBookingCostAndCount(List<Booking> bookings, T analytics) {
		BigInteger bookingCount = BigInteger.valueOf(0);
		Long bookingAmt = 0l;
		String currency = new String();
		if (bookings != null)
			for (Booking booking : bookings) {
				for (Order order : booking.getOrders()) {
					bookingAmt = bookingAmt + order.getFlightPrice().getAmount();
					currency = order.getFlightPrice().getCurrency();
					bookingCount.add(BigInteger.valueOf(1));
				}
			}

		Price price = new Price();
		price.setAmount(Double.valueOf(bookingAmt));
		price.setCurrency(currency);
		analytics.setBookingPrice(price);
		analytics.setBookingCount(bookingCount);

	}

	public <T extends AbstractAnalyticsItem> void setAncillaryCostAndCount(List<Booking> bookings, T analytics) {
		long ancillaryAmt = 0l;
		long count = 0l;
		String currency = new String();
		if (bookings != null) {
			for (Booking booking : bookings) {
				for (Passenger passenger : booking.getPassengers()) {
					for (PassengerSegment paxSeg : passenger.getPassengerSegments()) {
						for (Product product : paxSeg.getProducts()) {
							ancillaryAmt = ancillaryAmt + product.getPrice().getAmount();
							currency = product.getPrice().getCurrency();
							count = count + 1;
						}
					}
				}
			}
		}
		analytics.setAncillaryCount(BigInteger.valueOf(count));
		Price totalAncillaryCost = new Price();
		totalAncillaryCost.setAmount(Double.valueOf(ancillaryAmt));
		totalAncillaryCost.setCurrency(currency);
		analytics.setAncillaryPrice(totalAncillaryCost);
	}
}
