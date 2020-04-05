package com.teo2.prediosservices.repository;

import com.teo2.prediosservices.entity.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredioRepository extends JpaRepository<Predio, Long> {

    List<Predio> findByDisponible(Boolean disponible);
}
