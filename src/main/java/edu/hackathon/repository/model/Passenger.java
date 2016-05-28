package edu.hackathon.repository.model;

import java.util.List;

public class Passenger {

	private String firstName;

	private String middleName;

	private String lastName;

	private String passengerType;

	private String birthDate;

	private boolean isEmployee;

	private String employer;

	private String department;
	
	private String workingLocation;

	/**
	 * @return the workingLocation
	 */
	public String getWorkingLocation() {
		return workingLocation;
	}

	/**
	 * @param workingLocation the workingLocation to set
	 */
	public void setWorkingLocation(String workingLocation) {
		this.workingLocation = workingLocation;
	}

	private String organizationalRole;

	private List<PassengerSegment> passengerSegments;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<PassengerSegment> getPassengerSegments() {
		return passengerSegments;
	}

	public void setPassengerSegments(List<PassengerSegment> passengerSegments) {
		this.passengerSegments = passengerSegments;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getOrganizationalRole() {
		return organizationalRole;
	}

	public void setOrganizationalRole(String organizationalRole) {
		this.organizationalRole = organizationalRole;
	}

}
