/** AddressBookDTO.java */
package com.bridgelabz.addressbookappdevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "First Name can't be Empty")
    @Pattern(regexp = "^[A-Z][a-zA-z]{2,}$", message = "First Name is INVALID")
    private String firstName;

    private String lastName;

    @NotNull(message = "Address can't be Empty")
    @Size(max = 200, message = "Keep Address below 200 characters")
    private String address;

    @NotNull(message = "City can't be Empty")
    private String city;

    @NotNull(message = "State can't be Empty")
    private String state;

    @NotNull(message = "Zip can't be Empty")
    @Pattern(regexp = "[0-9]{6}", message ="Zip must be of 6 digit numeric value")
    private String zip;

    @NotNull(message = "Phone Number can't be Empty")
    @Pattern(regexp = "[0-9]{10}",message = "Enter a valid 10 digit Phone Number")
    private String phoneNumber;

    @NotNull(message = "Email can't be Empty")
    @Email
    private String email;
}
