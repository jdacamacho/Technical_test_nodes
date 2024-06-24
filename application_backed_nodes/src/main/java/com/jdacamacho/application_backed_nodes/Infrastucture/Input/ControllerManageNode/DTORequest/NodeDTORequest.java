package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDTORequest {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @Valid
    @NotNull(message = "Coordinate cannot be null")
    private CoordinateDTORequest coordinate;
    
    public NodeDTORequest(){

    }
}
