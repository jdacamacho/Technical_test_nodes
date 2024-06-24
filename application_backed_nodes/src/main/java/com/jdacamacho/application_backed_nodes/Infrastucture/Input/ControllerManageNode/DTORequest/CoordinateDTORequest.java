package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinateDTORequest {

    @NotNull(message = "Value X cannot be null")
    private double valueX;

    @NotNull(message = "Value Y cannot be null")
    private double valueY;
    
    public CoordinateDTORequest(){

    }
}
