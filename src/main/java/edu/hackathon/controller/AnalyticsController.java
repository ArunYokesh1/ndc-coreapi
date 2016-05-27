/**
 * 
 */
package edu.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.hackathon.domain.Forecast;


/**
 * @author Prabu S B
 *
 */
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
	
	/**
	 * Return all the users from the institutions.
	 * @return the list of user from the institutions
	 */
	@RequestMapping
    @ResponseBody
    public HttpEntity<List<Forecast>> users(HttpServletRequest request) {
        return new ResponseEntity<List<Forecast>>(new ArrayList(), HttpStatus.OK);
    }

}
