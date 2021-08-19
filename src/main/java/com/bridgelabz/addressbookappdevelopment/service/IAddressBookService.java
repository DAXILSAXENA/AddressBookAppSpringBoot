/** IAddressBookService.java */
package com.bridgelabz.addressbookappdevelopment.service;

import com.bridgelabz.addressbookappdevelopment.dto.AddressBookDTO;

import java.util.List;

public interface IAddressBookService {

    int addAddressDetails(AddressBookDTO addressBookDTO);

    List<AddressBookDTO> getAddressDetails();

    AddressBookDTO getAddressDetailsByID(int id);

    AddressBookDTO updateAddressDetails(int id, AddressBookDTO addressBookDTO);

    String deleteAddressDetails(int id);
}

