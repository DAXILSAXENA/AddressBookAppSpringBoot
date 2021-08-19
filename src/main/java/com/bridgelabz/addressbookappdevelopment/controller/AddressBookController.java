/**
 * Purpose: To construct AddressBook Application on Spring Boot that can perform
 * 			CRUD operations,Handle Exceptions and Validate details passed by user
 * 			in JSON format.
 *
 * @author DAXIL SAXENA
 * @since 14.08.2021
 */

package com.bridgelabz.addressbookappdevelopment.controller;

import com.bridgelabz.addressbookappdevelopment.dto.AddressBookDTO;
import com.bridgelabz.addressbookappdevelopment.dto.ResponseDTO;
import com.bridgelabz.addressbookappdevelopment.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	/**
	 * Purpose: @PostMapping annotation used to insert person details in Address Book,
	 * 			@Valid validates pattern matching for various fields.
	 * 			@RequestBody receives request from user and pass it to AddressBookDTO.
	 */

	@PostMapping
	public ResponseEntity<ResponseDTO> addAddressDetails(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		ResponseDTO responseDTO = new ResponseDTO("Successfully added Address Book Details with user id provided in data",addressBookService.addAddressDetails(addressBookDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	/**
	 * Purpose: @GetMapping annotation used to get person details from Address Book.
	 */

	@GetMapping
	public ResponseEntity<ResponseDTO> getAddressDetails() {
		ResponseDTO responseDTO = new ResponseDTO("Successfully fetched all Address Book Details",addressBookService.getAddressDetails());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Purpose: @GetMapping annotation used to get person details from Address Book with
	 * 			given id passed as a @RequestParam.
	 */

	@GetMapping("/getaddressdetailsbyid")
	public ResponseEntity<ResponseDTO> getAddressDetailsByID(@RequestParam(name = "id") int id) {
		ResponseDTO responseDTO = new ResponseDTO("Successfully fetched Address Book Details for given id", addressBookService.getAddressDetailsByID(id));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Purpose: @PutMapping annotation used to update person details in Address Book based on a particular ID.
	 */

	@PutMapping("/updateaddressdetails")
	public ResponseEntity<ResponseDTO> updateAddressDetails(@RequestParam(name = "id") int id,
															@Valid @RequestBody AddressBookDTO addressBookDTO) {
		ResponseDTO responseDTO = new ResponseDTO("Successfully updated Address Book Details for given id", addressBookService.updateAddressDetails(id, addressBookDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	/**
	 * Purpose: @DeleteMapping annotation used to delete person details from Address Book based on a particular ID.
	 */

	@DeleteMapping("/deleteaddressdetails")
	public ResponseEntity<ResponseDTO> deleteAddressDetails(@RequestParam(name = "id") int id) {
		ResponseDTO responseDTO = new ResponseDTO("Successfully deleted Address Book Details for given id", addressBookService.deleteAddressDetails(id));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
