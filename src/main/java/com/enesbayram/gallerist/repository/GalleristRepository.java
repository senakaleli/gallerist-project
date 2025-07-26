package com.enesbayram.gallerist.repository;

import com.enesbayram.gallerist.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long> {
}
