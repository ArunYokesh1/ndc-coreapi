/**
 * 
 */
package edu.hackathon.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.hackathon.domain.Booking;


/**
 * @author x096284
 *
 */
public interface BookingRepository extends MongoRepository<Booking, String> {
	
	@Query("")
	public List<Booking> findBookingOrderedTimeWithinTime(Date start, Date end);

}
