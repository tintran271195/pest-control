package com.example.pestcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "staffs")
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phoneNumber;
    private String identityCard;
    private Date dob;
    private String email;
    private String address;

    @ManyToOne(targetEntity = Station.class, fetch = FetchType.EAGER)
    private Station station;
}
