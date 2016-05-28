/**
 * 
 */
package edu.hackathon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.hackathon.domain.Booking;


/**
 * @author x096284
 *
 */
public interface BookingRepository extends MongoRepository<Booking, String> {

}
