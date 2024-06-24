package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Input.MapperNodeInfrastructureDomainIntPort;
import com.jdacamacho.application_backed_nodes.Domain.Models.Node;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest.NodeDTORequest;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTOResponse.NodeDTOResponse;

@Service
public class MapperNodeInfrastructureDomainImplAdapter implements MapperNodeInfrastructureDomainIntPort{
    private final ModelMapper mapper;

    public MapperNodeInfrastructureDomainImplAdapter(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public Node mapRequestToModel(NodeDTORequest request) {
        return this.mapper.map(request, Node.class);
    }

    @Override
    public NodeDTOResponse mapModelToResponse(Node model) {
        return this.mapper.map(model, NodeDTOResponse.class);
    }

    @Override
    public List<NodeDTOResponse> mapModelToResponse(List<Node> models) {
        return this.mapper.map(models, new TypeToken<List<NodeDTOResponse>>(){}.getType());
    }
}
