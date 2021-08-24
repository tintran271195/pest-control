package com.example.pestcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberOfContract;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne
    private Station station;

    @OneToMany
    private List<Report> reports;

    private Boolean isEnabled;
    private Boolean isDelete;

}
