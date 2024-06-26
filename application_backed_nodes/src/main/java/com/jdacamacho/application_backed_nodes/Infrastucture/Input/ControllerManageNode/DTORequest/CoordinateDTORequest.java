package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinateDTORequest {

    @NotNull(message = "Value X cannot be null")
    @DecimalMin(value = "-84.0", message = "Value X must be greater than or equal to -84.0")
    @DecimalMax(value = "84.0", message = "Value X must be less than or equal to 84.0")
    private double valueX;

    @NotNull(message = "Value Y cannot be null")
    @DecimalMin(value = "-179.0", message = "Value Y must be greater than or equal to -179.0")
    @DecimalMax(value = "179.0", message = "Value Y must be less than or equal to 179.0")
    private double valueY;
    
    public CoordinateDTORequest(){

    }
}
