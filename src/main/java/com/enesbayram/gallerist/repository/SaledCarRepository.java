package com.enesbayram.gallerist.repository;

import com.enesbayram.gallerist.model.SaledCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long> {
}
