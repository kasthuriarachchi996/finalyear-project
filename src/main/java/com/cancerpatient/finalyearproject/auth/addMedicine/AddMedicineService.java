package com.cancerpatient.finalyearproject.auth.addMedicine;

import com.cancerpatient.finalyearproject.repository.AddMedicineRepository;
import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddMedicineService {

        private final AddMedicineRepository addMedicineRepository;

//        @Autowired
//        public MedicineService(AddMedicineRepository addMedicineRepository) {
//            this.addMedicineRepository = addMedicineRepository;
//        }

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
            // Check if the medicine exists
            Optional<AddMedicine> existingMedicineOptional = addMedicineRepository.findById(id);
            if (existingMedicineOptional.isPresent()) {
                AddMedicine existingMedicine = existingMedicineOptional.get();
                // Update fields as needed
                existingMedicine.setName(updatedMedicine.getName());
                existingMedicine.setDescription(updatedMedicine.getDescription());
                existingMedicine.setStock(updatedMedicine.getStock());

                // Save the updated medicine
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
}
