package com.cancerpatient.finalyearproject.auth.profile;

import com.cancerpatient.finalyearproject.auth.AuthenticationRequest;
import com.cancerpatient.finalyearproject.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/profile/{role}")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            @PathVariable String role
    ){
        return ResponseEntity.ok(profileService.authenticate(request));
    }}
