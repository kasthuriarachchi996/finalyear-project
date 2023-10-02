package com.cancerpatient.finalyearproject.auth.patientTreatment;

import com.cancerpatient.finalyearproject.auth.AuthenticationRequest;
import com.cancerpatient.finalyearproject.auth.AuthenticationResponse;
import com.cancerpatient.finalyearproject.auth.addMedicine.AddMedicineService;
import com.cancerpatient.finalyearproject.auth.profile.ProfileService;
import com.cancerpatient.finalyearproject.config.JwtService;
import com.cancerpatient.finalyearproject.repository.PatientTreatmentRepository;
import com.cancerpatient.finalyearproject.repository.UserRepository;
import com.cancerpatient.finalyearproject.user.User;
import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import com.cancerpatient.finalyearproject.user.treatment.PatientTreatment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PatientTreatmentService {

    private final PatientTreatmentRepository treatmentRepository;
    private final AddMedicineService medicineService;
    private final AddMedicineService addMedicine;
    private final ProfileService profileService;

    private final JwtService jwtService;


    public List<PatientTreatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Optional<PatientTreatment> getTreatmentById(Long id) {
        return treatmentRepository.findById(id);
    }

//    public PatientTreatment addTreatment(PatientTreatment treatment) {
//
//        AddMedicine medicine = treatment.getMedicine();
//        int currentStock = medicine.getStock();
//        int dosage = treatment.getDosage();
//        int frequency = treatment.getFrequency();
//        int duration= treatment.getDuration();
//        //int duration = calculateDurationInDays(treatment.getStartDate(), treatment.getEndDate());
//
//        int quantityUsed = dosage * frequency * duration;
//
//        if (currentStock >= quantityUsed) {
//            medicine.setStock(currentStock - quantityUsed);
//            medicineService.updateMedicine(treatment.getId(), medicine);
//            addMedicine.reduceStock(treatment);
//            return treatmentRepository.save(treatment);
//        }
//        else {
//            throw new IllegalArgumentException("Insufficient stock for medicine: " + medicine.getName());
//        }
//
//    }

    public PatientTreatment addTreatment(PatientTreatment treatment) {
        // Check medicine stock and update it
       // authenticates().getAddress();
        AddMedicine medicine = treatment.getMedicine();
        int currentStock = medicine.getStock();
        int dosage = treatment.getDosage();
        int frequency = treatment.getFrequency();
        int duration= treatment.getDuration();
        treatment.getSurgery();
        treatment.getChemotherapy();
        treatment.getRadiation();
        treatment.getBloodtest();
        treatment.getTestdescription();
        //int duration = calculateDurationInDays(treatment.getStartDate(), treatment.getEndDate());

        int quantityUsed = dosage * frequency * duration;
//        medicine.setStock(currentStock - quantityUsed);
//        medicineService.updateMedicine(treatment.getId(), medicine);
//        return treatmentRepository.save(treatment);


        if (currentStock >= quantityUsed) {
           medicine.setStock(currentStock - quantityUsed);
            medicineService.updateMedicine(medicine.getId(), medicine);
            return treatmentRepository.save(treatment);
        }
        //return null;
        else {
            throw new IllegalArgumentException("Insufficient stock for medicine: " + medicine.getName());
        }

//        List<AddMedicine> medicines = treatment.getMedicines();
//
//        // Check medicine stock for each medicine in the list and update it
//        for (AddMedicine medicine : medicines) {
//            int currentStock = medicine.getStock();
//            int dosage = treatment.getDosage();
//            int duration= treatment.getDuration();
//            int frequency = treatment.getFrequency();
//            //int duration= treatment.getDuration();
//            treatment.getSurgery();
//            treatment.getChemotherapy();
//            treatment.getRadiation();
//            treatment.getBloodtest();
//            treatment.getTestdescription();
//            // You may need to calculate dosage, frequency, and duration for each medicine
//            int quantityUsed = dosage * frequency * duration;
//////        medicine.setStock(currentStock - quantityUsed);
//////        medicineService.updateMedicine(treatment.getId(), medicine);
//////        return treatmentRepository.save(treatment);
//
//            if (currentStock >= quantityUsed) {
//              medicine.setStock(currentStock - quantityUsed);
//              medicineService.updateMedicine(medicine.getId(), medicine);
//              return treatmentRepository.save(treatment);
//          }
//          //return null;
//            else {
//              throw new IllegalArgumentException("Insufficient stock for medicine: " + medicine.getName());
//         }
//        }

        //return treatmentRepository.save(treatment);
    }

    public void deleteTreatment(Long id) {
        treatmentRepository.deleteById(id);
    }

    private int calculateDurationInDays(Date startDate, Date endDate) {
        if (endDate.before(startDate)) {
            throw new IllegalArgumentException("End date must be after or equal to start date.");
        }

        long durationInMillis = endDate.getTime() - startDate.getTime();

        long durationInDays = TimeUnit.MILLISECONDS.toDays(durationInMillis);

        return (int) durationInDays;
    }

}
