/** AddressBookService.java */
package com.bridgelabz.addressbookappdevelopment.service;

import com.bridgelabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopment.entity.AddressBook;
import com.bridgelabz.addressbookappdevelopment.exception.AddressBookException;
import com.bridgelabz.addressbookappdevelopment.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int addAddressDetails(AddressBookDTO addressBookDTO) {
        AddressBook addressBookData = modelMapper.map(addressBookDTO,AddressBook.class);
        addressBookRepository.save(addressBookData);
        int id = addressBookData.getId();
        return id;
    }

    @Override
    public List<AddressBookDTO> getAddressDetails() {
        return addressBookRepository.findAll().stream()
                .map(addressBook -> modelMapper.map(addressBook,AddressBookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AddressBookDTO getAddressDetailsByID(int id) {
        AddressBook addressBook = findAddressBookById(id);
        AddressBookDTO addressBookDTO = modelMapper.map(addressBook,AddressBookDTO.class);
        return addressBookDTO;
    }

    @Override
    public AddressBookDTO updateAddressDetails(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = findAddressBookById(id);
        String[] ignoreFields = {"id", "name", "createdDate"};
        BeanUtils.copyProperties(addressBookDTO, addressBook, ignoreFields);
        addressBookRepository.save(addressBook);
        return  addressBookDTO;
    }

    @Override
    public String deleteAddressDetails(int id) {
        AddressBook addressBook = findAddressBookById(id);
        addressBookRepository.delete(addressBook);
        return "AddressBook Successfully Deleted";
    }

    private AddressBook findAddressBookById(int id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("No Details found for given id!!!"));
    }
}