package com.cancerpatient.finalyearproject.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
}
