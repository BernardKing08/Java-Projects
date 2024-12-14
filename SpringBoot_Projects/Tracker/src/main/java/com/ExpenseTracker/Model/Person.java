package com.ExpenseTracker.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please provide a valid email address")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @NotBlank(message = "Confirm Email must not be blank")
    @Email(message = "Please provide a valid confirm email address")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 5, message = "Password must be at least 5 characters long")
    @Column(name = "pwd")
    private String pwd;

    @NotBlank(message = "Confirm Password must not be blank")
    @Size(min = 5, message = "Confirm Password must be at least 5 characters long")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

}
