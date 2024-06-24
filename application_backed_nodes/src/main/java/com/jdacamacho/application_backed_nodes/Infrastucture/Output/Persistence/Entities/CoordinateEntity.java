package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Coordinates")
@Data
@AllArgsConstructor
public class CoordinateEntity {
    @Id
    @Column(name = "coordinate_id")
    private long id;

    @Column(name = "coordinate_value_X", nullable = false)
    private double valueX;

    @Column(name = "coordinate_value_Y", nullable =  false)
    private double valueY;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "coordinate_node_id")
    private NodeEntity objNode;

    public CoordinateEntity(){
        
    }

}
