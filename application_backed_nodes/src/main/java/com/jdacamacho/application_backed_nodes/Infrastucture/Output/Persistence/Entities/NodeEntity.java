package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Nodes")
@Data
@AllArgsConstructor
public class NodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private long id;

    @Column(name = "node_name" , nullable = false , unique = true , length = 50)
    private String name;

    @Column(name = "node_description" , nullable = false , unique = false , length = 400)
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "objNode")
    private CoordinateEntity coordinate;

    public NodeEntity(){

    }

}
