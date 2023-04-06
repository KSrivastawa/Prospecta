package com.ketan.prospecta.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Entry {

	@Id
    @JsonProperty("API")
	private String api; 
	
	@JsonProperty("Description")
	private String description; 
	
	@JsonProperty("Auth")
	private String auth; 
	
	@JsonProperty("HTTPS")
	private boolean https; 
	
	@JsonProperty("Cors")
	private String cors; 
	
	@JsonProperty("Link")
	private String link;
	
	@JsonProperty("Category")
	private String category;
	
	
}
