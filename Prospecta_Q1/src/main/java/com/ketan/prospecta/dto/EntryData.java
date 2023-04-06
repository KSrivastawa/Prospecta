package com.ketan.prospecta.dto;

import java.util.List;

import com.ketan.prospecta.entity.Entry;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntryData {

	private int count;
	private List<Entry> entries;
	
}
