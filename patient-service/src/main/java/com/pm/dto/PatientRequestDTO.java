package com.pm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientRequestDTO {

    @NotBlank(message = "name is required")
    @Size(max = 100,message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "address is required ")
    private String address;

    @NotBlank(message = "Date of Birth is required")
    private  String dateOfBirth;

    @NotBlank(message = "Registered Date is required")
    private  String registeredDate;


}
