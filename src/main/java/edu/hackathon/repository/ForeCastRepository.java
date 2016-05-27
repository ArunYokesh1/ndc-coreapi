/**
 * 
 */
package edu.hackathon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.hackathon.domain.Forecast;

/**
 * @author x096284
 *
 */
public interface ForeCastRepository extends MongoRepository<Forecast, String> {

}
