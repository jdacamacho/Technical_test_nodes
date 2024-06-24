package com.jdacamacho.application_backed_nodes.Application.Input;

import java.util.List;

import com.jdacamacho.application_backed_nodes.Domain.Models.Node;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest.NodeDTORequest;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTOResponse.NodeDTOResponse;

public interface MapperNodeInfrastructureDomainIntPort {
    Node mapRequestToModel(NodeDTORequest request);
    NodeDTOResponse mapModelToResponse(Node model);
    List<NodeDTOResponse> mapModelToResponse(List<Node> models);
}
