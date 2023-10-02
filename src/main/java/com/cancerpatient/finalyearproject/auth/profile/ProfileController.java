package com.cancerpatient.finalyearproject.auth.profile;

import com.cancerpatient.finalyearproject.auth.AuthenticationRequest;
import com.cancerpatient.finalyearproject.auth.AuthenticationResponse;
import com.cancerpatient.finalyearproject.auth.patientTreatment.PatientTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;
    private final PatientTreatmentService patientTreatmentService;

    @PostMapping("/profile/{role}")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            @PathVariable String role
    ){
        return ResponseEntity.ok(profileService.authenticate(request));

    }
//    public ResponseEntity<AuthenticationResponse> authenticates(
//            @RequestBody AuthenticationRequest request,
//            @PathVariable String role
//    ){
//        return ResponseEntity.ok(patientTreatmentService.authenticates(request));
//
//    }

}
