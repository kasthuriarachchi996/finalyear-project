package com.cancerpatient.finalyearproject.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/{role}")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request,
            @PathVariable String role
    ) {
        return ResponseEntity.ok(authenticationService.register(request, role));
    }

    @PostMapping("/authenticate/{role}")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            @PathVariable String role
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
