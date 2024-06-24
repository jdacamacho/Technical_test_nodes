package com.jdacamacho.application_backed_nodes.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private long id;
    private String name;
    private String description;
    private Coordinate coordinate;

    public Node(){

    }

}
