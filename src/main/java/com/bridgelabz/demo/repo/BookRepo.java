package com.bridgelabz.demo.repo;

import com.bridgelabz.demo.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<AddressBook, Integer> {

}
