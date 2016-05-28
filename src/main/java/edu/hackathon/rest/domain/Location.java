package edu.hackathon.rest.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location extends AbstractAnalyticsItem {

	@JsonProperty
	private String code;

	@JsonProperty
	private String name;

	@JsonProperty
	private List<Department> departments;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public void addDepartments(Department department) {
		if (this.departments == null) {
			this.departments = new ArrayList<>();
		}
		this.departments.add(department);
	}

}
