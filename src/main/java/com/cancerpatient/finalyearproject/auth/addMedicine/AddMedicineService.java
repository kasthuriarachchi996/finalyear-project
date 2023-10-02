package com.cancerpatient.finalyearproject.auth.addMedicine;

import com.cancerpatient.finalyearproject.repository.AddMedicineRepository;
import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import com.cancerpatient.finalyearproject.user.treatment.PatientTreatment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddMedicineService {

    private final AddMedicineRepository addMedicineRepository;


    public List<AddMedicine> getAllMedicines() {
        return addMedicineRepository.findAll();
    }

    public Optional<AddMedicine> getMedicineById(Long id) {
        return addMedicineRepository.findById(id);
    }

    public AddMedicine addMedicine(AddMedicine medicine) {
        // You can perform validation or business logic here before saving
        return addMedicineRepository.save(medicine);
    }

    public AddMedicine updateMedicine(Long id, AddMedicine updatedMedicine) {
        Optional<AddMedicine> existingMedicineOptional = addMedicineRepository.findById(id);
        if (existingMedicineOptional.isPresent()) {
            AddMedicine existingMedicine = existingMedicineOptional.get();
            existingMedicine.setName(updatedMedicine.getName());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            existingMedicine.setStock(updatedMedicine.getStock());

            return addMedicineRepository.save(existingMedicine);
        } else {
            throw new IllegalArgumentException("Medicine not found with id: " + id);
        }
    }

    public void deleteMedicine(Long id) {
        // Check if the medicine exists
        if (addMedicineRepository.existsById(id)) {
            addMedicineRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Medicine not found with id: " + id);
        }
    }

    public AddMedicine reduceStock(PatientTreatment treatment) {
        if (treatment != null) {
            Optional<AddMedicine> medicineData = addMedicineRepository.findById(treatment.getMedicine().getId());
            if (medicineData.isPresent()) {
                AddMedicine existingMedicine = medicineData.get();

                existingMedicine.setStock(existingMedicine.getStock() - treatment.getDosage());

                return addMedicineRepository.save(existingMedicine);
            } else {
                throw new IllegalArgumentException("Medicine not found with id: " + treatment.getMedicine().getId());
            }
        }
return null;
    }
}

