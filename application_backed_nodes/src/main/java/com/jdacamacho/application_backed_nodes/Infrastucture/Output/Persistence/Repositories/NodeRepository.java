package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Entities.NodeEntity;

@Repository
public interface NodeRepository extends JpaRepository< NodeEntity, Long> {
    List<NodeEntity> findAllByNameContainingIgnoreCase(String name);
    boolean existsByName(String name);
}
