package com.realestate.realestate.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "phone_no") // Fixed spelling
    private Long phoneNo; 

    private String email;

    private String gender;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "accommodation_status") // Fixed spelling
    private String accommodationStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Changed to LocalDateTime for timestamp

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
