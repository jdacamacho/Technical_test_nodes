package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Output.ManageNodeGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Domain.Models.Node;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Node> findAllByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByName'");
    }

    @Override
    public Node save(Node node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Node findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Node node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean existsById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public boolean existsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByName'");
    }

    @Override
    public boolean existsByCoordinates(double valueX, double valueY) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByCoordinates'");
    }

    
    
}
