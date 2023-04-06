package com.ketan.prospecta.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyError {

	private LocalDateTime dateTime;
	private String message;
	private String description;
	
}
