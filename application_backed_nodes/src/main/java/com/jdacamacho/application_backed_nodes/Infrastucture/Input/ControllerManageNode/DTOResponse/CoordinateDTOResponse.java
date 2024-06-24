package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoordinateDTOResponse {
    private long id;
    private double valueX;
    private double valueY;

    public CoordinateDTOResponse(){
        
    }
}
