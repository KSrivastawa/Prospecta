package com.ketan.prospecta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ketan.prospecta.dto.EntryDto;
import com.ketan.prospecta.dto.EntryDtoData;
import com.ketan.prospecta.exception.EntryException;
import com.ketan.prospecta.repository.EntryRepository;
import com.ketan.prospecta.serviceimpl.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.ketan.prospecta.dto.EntryData;
import com.ketan.prospecta.entity.Entry;


@RestController
public class EntryController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EntryServiceImpl entryServiceImpl;
	
	@Autowired
	private EntryRepository entryRepo;

	// Coding Question 1
	// when you fetch all entries based on their category, use this local host url
	// http://localhost:8885/entries/animals
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<EntryDtoData> getRequiredEntriesHandler(@PathVariable String category) throws EntryException {
		
		EntryData data = restTemplate.getForObject("https://api.publicapis.org/entries", EntryData.class);
		
		List<Entry> entries = data.getEntries();
		
		List<EntryDto> dtos = new ArrayList<>();
		
		for(int i=0; i<entries.size(); i++) {
			if(entries.get(i).getCategory().equalsIgnoreCase(category)) {
				
				for(Entry entry : entries) {
					
					if(entry.getCategory().equalsIgnoreCase(entries.get(i).getCategory())) {
						
						dtos.add(new EntryDto(entry.getApi(), entry.getDescription()));
					}
				}
				
				break;
			}
		}
		
		EntryDtoData entryDtoData = new EntryDtoData();
		entryDtoData.setCount(dtos.size());
		entryDtoData.setEntries(dtos);
	
		return new ResponseEntity<EntryDtoData>(entryDtoData, HttpStatus.OK);
		
	}


	// Coding Question 2
	// when you save entries(List) with body/data, use this local host url
	// http://localhost:8885/entries
	
	@PostMapping("/entries")
	public ResponseEntity<EntryData> saveEntriesHandler(@RequestBody List<Entry> entry)throws Exception{
		
		EntryData data = restTemplate.getForObject("https://api.publicapis.org/entries", EntryData.class);
		
		List<Entry> entries = data.getEntries();
		
		
		entries.addAll(entry);
		EntryData ed=new EntryData();
		
		if(entries.isEmpty()) {
			List<Entry> list = entryServiceImpl.saveEntries(entries);
			
			ed.setEntries(list);
			ed.setCount(list.size());
		}else {
			List<Entry> list=entryServiceImpl.saveEntries(entry);
			List<Entry> l=entryRepo.findAll();
			
			ed.setEntries(l);
			ed.setCount(l.size());
			
		}
		
		return new ResponseEntity<EntryData>(ed, HttpStatus.CREATED);
		
	}
	
}
