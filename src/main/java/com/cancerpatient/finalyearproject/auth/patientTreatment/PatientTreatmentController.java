package com.cancerpatient.finalyearproject.auth.patientTreatment;

import com.cancerpatient.finalyearproject.user.treatment.PatientTreatment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class PatientTreatmentController {

    private final PatientTreatmentService treatmentService;


    @GetMapping("/getAllTreatments")
    public ResponseEntity<List<PatientTreatment>> getAllTreatments() {
        List<PatientTreatment> treatments = treatmentService.getAllTreatments();
        return new ResponseEntity<>(treatments, HttpStatus.OK);
    }

    @GetMapping("/Treatment/{id}")
    public ResponseEntity<PatientTreatment> getTreatmentById(@PathVariable Long id) {
        Optional<PatientTreatment> treatment = treatmentService.getTreatmentById(id);
        return treatment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addTreatment")
    public ResponseEntity<PatientTreatment> addTreatment(@RequestBody PatientTreatment treatment) {
//        PatientTreatment newTreatment = treatmentService.addTreatment(treatment);
//        return new ResponseEntity<>(newTreatment, HttpStatus.CREATED);
        PatientTreatment newTreatment = treatmentService.addTreatment(treatment);
        return new ResponseEntity<>(newTreatment, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTreatment/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        treatmentService.deleteTreatment(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
