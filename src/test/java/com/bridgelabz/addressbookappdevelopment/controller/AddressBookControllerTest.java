package com.bridgelabz.addressbookappdevelopment.controller;

import com.bridgelabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopment.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevelopment.service.IAddressBookService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookControllerTest {

    @InjectMocks
    private AddressBookController addressBookController;

    @Mock
    private IAddressBookService addressBookService;

    @Test
    public void getAddressesTest() {
        when(addressBookService.getAddressDetails()).thenReturn(Lists.newArrayList(new AddressBookDTO(), new AddressBookDTO()));
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.getAddressDetails();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Successfully fetched all Address Book Details", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    @Test
    public void addAddressDetailsTest() {
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Daxil");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(addressBookService.addAddressDetails(addressBookDTO)).thenReturn(id);
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.addAddressDetails(addressBookDTO);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Successfully added Address Book Details with user id provided in data", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    @Test
    public void deleteAddressDetailsTest() {
        int id = 1;

        when(addressBookService.deleteAddressDetails(id)).thenReturn("AddressBook Successfully Deleted");
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.deleteAddressDetails(id);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Successfully deleted Address Book Details for given id", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    @Test
    public void updateAddressDetailsTest() {
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Daxil");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(addressBookService.updateAddressDetails(id, addressBookDTO)).thenReturn(new AddressBookDTO());
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.updateAddressDetails(id, addressBookDTO);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Successfully updated Address Book Details for given id", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    @Test
    public void getAddressDetailsByIDTest() {
        int id = 1;

        when(addressBookService.getAddressDetailsByID(id)).thenReturn(new AddressBookDTO());
        ResponseEntity<ResponseDTO> responseEntity = addressBookController.getAddressDetailsByID(id);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Successfully fetched Address Book Details for given id", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }
}
