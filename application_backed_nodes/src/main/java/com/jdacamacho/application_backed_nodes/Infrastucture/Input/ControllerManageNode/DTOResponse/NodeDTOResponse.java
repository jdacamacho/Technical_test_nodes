package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDTOResponse {
    private long id;
    private String name;
    private String description;
    private CoordinateDTOResponse coordinate;

    public NodeDTOResponse(){
        
    }
}
