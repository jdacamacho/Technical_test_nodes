package com.jdacamacho.application_backed_nodes.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private long id;
    private double valueX;
    private double valueY;
    private Node objNode;

    public Coordinate(){
        
    }
}
