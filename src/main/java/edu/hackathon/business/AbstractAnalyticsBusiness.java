package edu.hackathon.business;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.ListUtils;

import edu.hackathon.repository.model.Booking;
import edu.hackathon.repository.model.Order;
import edu.hackathon.repository.model.Passenger;
import edu.hackathon.repository.model.PassengerSegment;
import edu.hackathon.repository.model.Product;
import edu.hackathon.rest.domain.AbstractAnalyticsItem;
import edu.hackathon.rest.domain.Price;

public abstract class AbstractAnalyticsBusiness {

	public <T extends AbstractAnalyticsItem> void setBookingCostAndCount(List<Booking> bookings, T analytics,
			boolean randomaise) {
		long bookingCount = 0l;
		Long bookingAmt = 0l;
		String currency = new String();
		for (Booking booking : ListUtils.emptyIfNull(bookings)) {
			for (Order order : ListUtils.emptyIfNull(booking.getOrders())) {
				bookingAmt = bookingAmt + order.getFlightPrice().getAmount();
				currency = order.getFlightPrice().getCurrency();
				bookingCount = bookingCount + 1;
			}
		}
		// randomise is for forecasting
		if (randomaise) {
			bookingAmt = bookingAmt + getRandom();
			bookingCount = bookingCount + getRandom();
		}
		Price price = new Price();
		price.setAmount(Double.valueOf(bookingAmt));
		price.setCurrency(currency);
		analytics.setBookingPrice(price);
		analytics.setBookingCount(BigInteger.valueOf(bookingCount));

	}

	public <T extends AbstractAnalyticsItem> void setAncillaryCostAndCount(List<Booking> bookings, T analytics,
			boolean randomaise) {
		long ancillaryAmt = 0l;
		long count = 0l;
		String currency = new String();
		for (Booking booking : ListUtils.emptyIfNull(bookings)) {
			for (Passenger passenger : ListUtils.emptyIfNull(booking.getPassengers())) {
				for (PassengerSegment paxSeg : ListUtils.emptyIfNull(passenger.getPassengerSegments())) {
					for (Product product : paxSeg.getProducts()) {
						ancillaryAmt = ancillaryAmt + product.getPrice().getAmount();
						currency = product.getPrice().getCurrency();
						count = count + 1;
					}
				}
			}
		}

		if (randomaise) {
			count = count + getRandom();
			ancillaryAmt = ancillaryAmt + getRandom();
		}

		analytics.setAncillaryCount(BigInteger.valueOf(count));
		Price totalAncillaryCost = new Price();
		totalAncillaryCost.setAmount(Double.valueOf(ancillaryAmt));
		totalAncillaryCost.setCurrency(currency);
		analytics.setAncillaryPrice(totalAncillaryCost);
	}

	private int getRandom() {
		int randomNumber = 0;
		int START = 1;
		int END = 10;
		Random random = new Random();
		for (int idx = 1; idx <= 10; ++idx) {

			if (START > END) {
				throw new IllegalArgumentException("Start cannot exceed End.");
			}
			// get the range, casting to long to avoid overflow problems
			long range = (long) END - (long) END + 1;
			// compute a fraction of the range, 0 <= frac < range
			long fraction = (long) (range * random.nextDouble());
			randomNumber = (int) (fraction + START);
		}
		return randomNumber;

	}

}
