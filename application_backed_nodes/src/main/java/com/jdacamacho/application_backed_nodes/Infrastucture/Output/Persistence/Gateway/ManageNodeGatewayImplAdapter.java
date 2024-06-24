package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Output.ManageNodeGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Domain.Models.Node;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Entities.NodeEntity;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Repositories.NodeRepository;

@Service
public class ManageNodeGatewayImplAdapter implements ManageNodeGatewayIntPort{

    private final NodeRepository serviceBD;
    private final ModelMapper mapper;

    public ManageNodeGatewayImplAdapter(NodeRepository serviceBD,
                                        ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<Node> findAll() {
        Iterable<NodeEntity> data = this.serviceBD.findAll();
        List<Node> response = this.mapper.map(data, new TypeToken<List<Node>>(){}.getType());
        return response;
    }

    @Override
    public List<Node> findAllByName(String name) {
        List<NodeEntity> data = this.serviceBD.findAllByNameContainingIgnoreCase(name);
        List<Node> response = this.mapper.map(data, new TypeToken<List<Node>>(){}.getType());
        return response;
    }

    @Override
    public Node save(Node node) {
        NodeEntity nodeToSave = this.mapper.map(node, NodeEntity.class);
        NodeEntity nodeSaved = this.serviceBD.save(nodeToSave);
        Node response = this.mapper.map(nodeSaved, Node.class);
        return response;
    }

    @Override
    public Node findById(long id) {
        NodeEntity data = this.serviceBD.findById(id).get();
        Node response = this.mapper.map(data, Node.class);
        return response;
    }

    @Override
    public void delete(Node node) {
        NodeEntity nodeToDelete = this.mapper.map(node, NodeEntity.class);
        this.serviceBD.delete(nodeToDelete);
    }

    @Override
    public boolean existsById(long id) {
        return this.serviceBD.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return this.serviceBD.existsByName(name);
    }
    
}
