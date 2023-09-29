package com.cancerpatient.finalyearproject.auth.addMedicine;

import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AddMedicineController {
    private final AddMedicineService medicineService;

//    @Autowired
//    public MedicineController(AddMedicineService medicineService) {
//        this.medicineService = medicineService;
//    }

    @GetMapping("/allmedicine")
    public ResponseEntity<List<AddMedicine>> getAllMedicines() {
        List<AddMedicine> medicines = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddMedicine> getMedicineById(@PathVariable Long id) {
        Optional<AddMedicine> medicine = medicineService.getMedicineById(id);
        return medicine.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addmedicine")
    public ResponseEntity<AddMedicine> addMedicine(@RequestBody AddMedicine medicine) {
        AddMedicine newMedicine = medicineService.addMedicine(medicine);
        return new ResponseEntity<>(newMedicine, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<AddMedicine> updateMedicine(@PathVariable Long id, @RequestBody AddMedicine updatedMedicine) {
        AddMedicine updated = medicineService.updateMedicine(id, updatedMedicine);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
