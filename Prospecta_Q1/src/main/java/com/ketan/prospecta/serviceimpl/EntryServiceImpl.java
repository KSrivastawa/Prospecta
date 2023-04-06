package com.ketan.prospecta.serviceimpl;

import java.util.List;

import com.ketan.prospecta.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketan.prospecta.entity.Entry;
import com.ketan.prospecta.exception.EntryException;
import com.ketan.prospecta.service.EntryService;


@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	@Override
	public List<Entry> saveEntries(List<Entry> entry) throws EntryException {
		
		List<Entry> entries = entryRepository.saveAll(entry);
		
		if(entries.isEmpty()) throw new EntryException("List is empty...");
		
		return entries;
	}

	
	
}
