package com.cancerpatient.finalyearproject.user.addmedicine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="medicine")
public class AddMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true ,nullable = false,updatable = false )
    private Long id;
    private String name;
    private String description;
    private int stock;
}
