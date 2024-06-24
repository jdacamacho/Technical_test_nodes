package com.jdacamacho.application_backed_nodes.Application.Output;

import java.util.List;

import com.jdacamacho.application_backed_nodes.Domain.Models.Node;

public interface ManageNodeGatewayIntPort {
    public List<Node> findAll();
    public List<Node> findAllByName(String name);
    public Node save(Node node);
    public Node findById(long id);
    public void delete (Node node);
    public boolean existsById(long id);
    public boolean existsByName(String name);
    public boolean existsByCoordinates(double valueX , double valueY);
}
