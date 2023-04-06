package com.ketan.prospecta.service;

import java.util.List;

import com.ketan.prospecta.entity.Entry;
import com.ketan.prospecta.exception.EntryException;

public interface EntryService {

	public List<Entry> saveEntries(List<Entry> entry)throws EntryException;
}
