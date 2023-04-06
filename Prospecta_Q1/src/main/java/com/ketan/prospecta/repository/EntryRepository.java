package com.ketan.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ketan.prospecta.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, String>{

	
}
