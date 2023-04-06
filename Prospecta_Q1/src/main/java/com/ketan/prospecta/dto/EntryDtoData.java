package com.ketan.prospecta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntryDtoData {

	private int count;
	private List<EntryDto> entries;
	
}
