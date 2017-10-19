package br.com.igor.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.listavip.model.Guest;

public interface GuestRepository extends JpaRepository<Guest,Long> {

}
