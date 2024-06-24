package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Entities.CoordinateEntity;

public interface CoordinateRepository extends JpaRepository<CoordinateEntity, Long>{
    public boolean existsByValueXAndValueY(double valueX, double valueY);
}
