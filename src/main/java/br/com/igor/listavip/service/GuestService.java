package br.com.igor.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.listavip.model.Guest;
import br.com.igor.listavip.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository repository;
	
	public Iterable<Guest> getAll(){
		return repository.findAll();
	}
	
	public void save(Guest guest) {
		repository.save(guest);
	}
	
}
