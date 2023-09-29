package com.cancerpatient.finalyearproject.repository;

import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddMedicineRepository extends JpaRepository<AddMedicine,Long> {
}
