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

    public void setNodeToCoordinate(){
        this.coordinate.setObjNode(this);
    }

    public void update(Node newNode){
        this.name = newNode.getName();
        this.description = newNode.getDescription();
        this.coordinate.setValueX(newNode.getCoordinate().getValueX());
        this.coordinate.setValueY(newNode.getCoordinate().getValueY());
    }

    public boolean verifyName(Node newNode){
        return this.name.equals(newNode.getName());
    }

    public boolean verifyCoordinate(Coordinate newCoordinate){
        return this.coordinate.getValueX() == newCoordinate.getValueX() && 
           this.coordinate.getValueY() == newCoordinate.getValueY();
    }

}
