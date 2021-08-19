/** AddressBookRepository.java */
package com.bridgelabz.addressbookappdevelopment.repository;

import com.bridgelabz.addressbookappdevelopment.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    }
