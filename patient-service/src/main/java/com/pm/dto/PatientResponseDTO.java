package com.pm.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientResponseDTO {

    private String id;

    private String name;

    private  String email;

    private  String address;

    private String dateOfBirth;
}
