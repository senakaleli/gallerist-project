package com.enesbayram.gallerist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gallerist_car",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id" , "car_id"}, name = "uq_gallerist_car")}) // bir galleristid-carid eşleşmesini tekrarlamaması için.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleristCar extends BaseEntity{

    @ManyToOne
    private Gallerist gallerist;

    @OneToOne
    private Car car;
}
