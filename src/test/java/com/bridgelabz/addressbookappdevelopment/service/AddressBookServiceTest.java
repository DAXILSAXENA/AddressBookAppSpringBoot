package com.bridgelabz.addressbookappdevelopment.service;

import com.bridgelabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopment.entity.AddressBook;
import com.bridgelabz.addressbookappdevelopment.exception.AddressBookException;
import com.bridgelabz.addressbookappdevelopment.repository.AddressBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService addressBookService;

    @Mock
    private AddressBookRepository addressBookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void getAddressDetailsTest(){
        List<AddressBook> addressBookList = new ArrayList<>();
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Daxil");
        addressBook.setLastName("Saxena");
        addressBook.setAddress("Rajnagar Extension");
        addressBook.setCity("Ghaziabad");
        addressBook.setState("UP");
        addressBook.setZip("201017");
        addressBook.setPhoneNumber("1234567890");
        addressBook.setEmail("abc@gmail.com");
        addressBookList.add(addressBook);

        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Daxil");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(addressBookRepository.findAll()).thenReturn(addressBookList);
        when(modelMapper.map(addressBookList.get(0),AddressBookDTO.class)).thenReturn(addressBookDTO);

        List<AddressBookDTO> actualAddressList = addressBookService.getAddressDetails();

        assertNotNull(actualAddressList);
        assertEquals("Daxil", actualAddressList.get(0).getFirstName());
        assertEquals("Saxena", actualAddressList.get(0).getLastName());
        assertEquals("Rajnagar Extension", actualAddressList.get(0).getAddress());
        assertEquals("Ghaziabad", actualAddressList.get(0).getCity());
        assertEquals("UP", actualAddressList.get(0).getState());
        assertEquals("201017", actualAddressList.get(0).getZip());
        assertEquals("1234567890", actualAddressList.get(0).getPhoneNumber());
        assertEquals("abc@gmail.com", actualAddressList.get(0).getEmail());
    }

    @Test(expected = AddressBookException.class)
    public void deleteAddressDetails_whenFindById_shouldThrowExceptionTest() {
        int id = 1;

        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        addressBookService.deleteAddressDetails(id);
    }

    @Test
    public void deleteAddressDetailsTest(){
        int id = 1;
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Daxil");
        addressBook.setLastName("Saxena");
        addressBook.setAddress("Rajnagar Extension");
        addressBook.setCity("Ghaziabad");
        addressBook.setState("UP");
        addressBook.setZip("201017");
        addressBook.setPhoneNumber("1234567890");
        addressBook.setEmail("abc@gmail.com");

        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBook));
        String string = addressBookService.deleteAddressDetails(id);
        assertNotNull(string);
    }

    @Test
    public void addAddressDetailsTest() {

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Daxil");
        addressBook.setLastName("Saxena");
        addressBook.setAddress("Rajnagar Extension");
        addressBook.setCity("Ghaziabad");
        addressBook.setState("UP");
        addressBook.setZip("201017");
        addressBook.setPhoneNumber("1234567890");
        addressBook.setEmail("abc@gmail.com");

        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Daxil");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(modelMapper.map(addressBookDTO,AddressBook.class)).thenReturn(addressBook);
        when(addressBookRepository.save(addressBook)).thenReturn(addressBook);

        int id = addressBookService.addAddressDetails(addressBookDTO);
        assertNotNull(id);
        assertEquals(1, id);
    }

    @Test(expected = AddressBookException.class)
    public void updateAddressDetails_whenFindById_shouldThrowExceptionTest() {
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Yashk");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        addressBookService.updateAddressDetails(id, addressBookDTO);
    }

    @Test
    public void updateAddressDetailsTest(){
        int id = 1;
        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Yashk");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Daxil");
        addressBook.setLastName("Saxena");
        addressBook.setAddress("Rajnagar Extension");
        addressBook.setCity("Ghaziabad");
        addressBook.setState("UP");
        addressBook.setZip("201017");
        addressBook.setPhoneNumber("1234567890");
        addressBook.setEmail("abc@gmail.com");

        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBook));
        when(addressBookRepository.save(addressBook)).thenReturn(addressBook);
        AddressBookDTO actualAddressBookDTO = addressBookService.updateAddressDetails(id, addressBookDTO);
        ArgumentCaptor<AddressBook> addressBookArgumentCaptor = ArgumentCaptor.forClass(
                AddressBook.class);
        verify(addressBookRepository, times(1)).save(addressBookArgumentCaptor.capture());
        assertNotNull(actualAddressBookDTO);
        assertEquals("Yashk", addressBookArgumentCaptor.getValue().getFirstName());
        assertEquals("Saxena", addressBookArgumentCaptor.getValue().getLastName());
        assertEquals("Rajnagar Extension", addressBookArgumentCaptor.getValue().getAddress());
        assertEquals("Ghaziabad", addressBookArgumentCaptor.getValue().getCity());
        assertEquals("UP", addressBookArgumentCaptor.getValue().getState());
        assertEquals("201017", addressBookArgumentCaptor.getValue().getZip());
        assertEquals("1234567890", addressBookArgumentCaptor.getValue().getPhoneNumber());
        assertEquals("abc@gmail.com", addressBookArgumentCaptor.getValue().getEmail());

    }

    @Test(expected = AddressBookException.class)
    public void getAddressDetailsByID_whenFindById_shouldThrowExceptionTest() {
        int id = 1;

        when(addressBookRepository.findById(id)).thenReturn(Optional.empty());
        addressBookService.getAddressDetailsByID(id);
    }

    @Test
    public void getAddressDetailsByIDTest(){
        int id = 1;

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName("Daxil");
        addressBook.setLastName("Saxena");
        addressBook.setAddress("Rajnagar Extension");
        addressBook.setCity("Ghaziabad");
        addressBook.setState("UP");
        addressBook.setZip("201017");
        addressBook.setPhoneNumber("1234567890");
        addressBook.setEmail("abc@gmail.com");

        AddressBookDTO addressBookDTO = new AddressBookDTO();
        addressBookDTO.setFirstName("Daxil");
        addressBookDTO.setLastName("Saxena");
        addressBookDTO.setAddress("Rajnagar Extension");
        addressBookDTO.setCity("Ghaziabad");
        addressBookDTO.setState("UP");
        addressBookDTO.setZip("201017");
        addressBookDTO.setPhoneNumber("1234567890");
        addressBookDTO.setEmail("abc@gmail.com");

        when(addressBookRepository.findById(id)).thenReturn(Optional.of(addressBook));
        when(modelMapper.map(addressBook, AddressBookDTO.class)).thenReturn(addressBookDTO);

        AddressBookDTO actualAddressBookDTO = addressBookService.getAddressDetailsByID(id);

        assertNotNull(actualAddressBookDTO);
        assertEquals("Daxil", actualAddressBookDTO.getFirstName());
        assertEquals("Saxena", actualAddressBookDTO.getLastName());
        assertEquals("Rajnagar Extension", actualAddressBookDTO.getAddress());
        assertEquals("Ghaziabad", actualAddressBookDTO.getCity());
        assertEquals("UP", actualAddressBookDTO.getState());
        assertEquals("201017", actualAddressBookDTO.getZip());
        assertEquals("1234567890", actualAddressBookDTO.getPhoneNumber());
        assertEquals("abc@gmail.com", actualAddressBookDTO.getEmail());
    }
}
