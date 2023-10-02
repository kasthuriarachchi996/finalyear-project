package com.cancerpatient.finalyearproject.repository;

import com.cancerpatient.finalyearproject.user.treatment.PatientTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment,Long> {

//    List<PatientTreatment> findByPatientId(Long patientId);
}
