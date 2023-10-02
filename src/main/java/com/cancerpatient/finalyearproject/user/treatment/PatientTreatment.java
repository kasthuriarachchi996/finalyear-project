package com.cancerpatient.finalyearproject.user.treatment;

import com.cancerpatient.finalyearproject.user.User;
import com.cancerpatient.finalyearproject.user.addmedicine.AddMedicine;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="treatment")
public class PatientTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//@ManyToMany
//@JoinTable(
//        name = "treatment_medicine",
//        joinColumns = @JoinColumn(name = "treatment_id"),
//        inverseJoinColumns = @JoinColumn(name = "medicine_id")
//)
//        private List<AddMedicine> medicines;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private AddMedicine medicine;

//    @ManyToOne
//    @JoinColumn(name = "patient_details")
//    private User user;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private Date endDate;

    private int duration;
    private int dosage;
    private int frequency;
    private String description;
    private String surgery;
    private String chemotherapy;
    private String radiation;
    private String bloodtest;
    private String testdescription;
}
