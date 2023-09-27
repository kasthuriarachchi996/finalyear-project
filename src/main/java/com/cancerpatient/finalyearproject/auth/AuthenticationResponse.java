package com.cancerpatient.finalyearproject.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
}
