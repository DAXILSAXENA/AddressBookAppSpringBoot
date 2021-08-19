/** ResponseDTO.java */
package com.bridgelabz.addressbookappdevelopment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
}