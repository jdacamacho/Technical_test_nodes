package com.jdacamacho.application_backed_nodes.Domain.UseCases;

import java.util.List;

import com.jdacamacho.application_backed_nodes.Application.Input.ManageNodeCUIntPort;
import com.jdacamacho.application_backed_nodes.Application.Output.ExceptionFormatterIntPort;
import com.jdacamacho.application_backed_nodes.Application.Output.ManageCoordinateGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Application.Output.ManageNodeGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Domain.Models.Node;

public class ManageNodeCUImplAdapter implements ManageNodeCUIntPort{
    private final ManageNodeGatewayIntPort gatewayNode;
    private final ManageCoordinateGatewayIntPort gatewayCoordinate;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageNodeCUImplAdapter(ManageNodeGatewayIntPort gatewayNode,
                                    ManageCoordinateGatewayIntPort gatewayCoordinate,
                                    ExceptionFormatterIntPort exceptionFormatter){
        this.gatewayNode = gatewayNode;
        this.gatewayCoordinate = gatewayCoordinate;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Node> listNodes() {
        List<Node> nodes = this.gatewayNode.findAll();

        if(nodes.isEmpty()){
            this.exceptionFormatter.responseNoData("There are no nodes in the System...");
        }

        return nodes;
    }

    @Override
    public List<Node> listNodesByName(String name) {
        List<Node> nodes = this.gatewayNode.findAllByName(name);

        if(nodes.isEmpty()){
            this.exceptionFormatter.responseNoData("There are no nodes in the System...");
        }

        return nodes;
    }

    @Override
    public Node createNode(Node node) {
        
        if(this.gatewayNode.existsByName(node.getName())){
            this.exceptionFormatter.responseEntityExists("There is a node with that name...");
        }
        if(this.gatewayCoordinate.existsByCoordinates(node.getCoordinate().getValueX(), node.getCoordinate().getValueY())){
            this.exceptionFormatter.responseEntityExists("There is already a node located at that position...");
        }

        node.setNodeToCoordinate();

        return this.gatewayNode.save(node);
    }

    @Override
    public Node updateNode(long id, Node node) {
        
        if(!this.gatewayNode.existsById(id)){
            this.exceptionFormatter.responseEntityNotFound("Was not found a node with that id...");
        }

        Node oldNode = this.gatewayNode.findById(id);

        boolean flagNode = this.gatewayNode.existsByName(node.getName());
        boolean flagCoordinate = this.gatewayCoordinate.existsByCoordinates(node.getCoordinate().getValueX() , 
                                                                            node.getCoordinate().getValueY());

        if(flagNode && !oldNode.verifyName(node)){
            this.exceptionFormatter.responseEntityExists("There is a node with that name...");
        }
        if(flagCoordinate && !oldNode.verifyCoordinate(node.getCoordinate())){
            this.exceptionFormatter.responseEntityExists("There is already a node located at that position...");
        }

        oldNode.update(node);

        return this.gatewayNode.save(oldNode);
    }

    @Override
    public Node getNodeById(long id) {
        
        if(!this.gatewayNode.existsById(id)){
            this.exceptionFormatter.responseEntityNotFound("Was not found a node with that id...");
        }

        return this.gatewayNode.findById(id);
    }

    @Override
    public boolean deleteNode(long id) {
        
        if(!this.gatewayNode.existsById(id)){
            this.exceptionFormatter.responseEntityNotFound("Was not found a node with that id...");
        }

        Node nodeToDelete = this.gatewayNode.findById(id);

        this.gatewayNode.delete(nodeToDelete);

        return true;
    }


}
