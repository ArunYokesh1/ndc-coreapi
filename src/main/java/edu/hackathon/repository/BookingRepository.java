/**
 * 
 */
package edu.hackathon.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.hackathon.repository.model.Booking;


/**
 * @author x096284
 *
 */
@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
public interface BookingRepository extends MongoRepository<Booking, String> {
	
	public List<Booking> findByOrderedTimeBetween(DateTime start, DateTime end);

}
