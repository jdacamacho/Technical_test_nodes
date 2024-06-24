package com.jdacamacho.application_backed_nodes.Application.Input;

import java.util.List;

import com.jdacamacho.application_backed_nodes.Domain.Models.Node;

public interface ManageNodeCUIntPort {
    public List<Node> listNodes();
    public List<Node> listNodesByName(String name);
    public Node createNode(Node node);
    public Node updateNode(long id, Node node);
    public Node getNodeById(long id);
    public boolean deleteNode(long id);
}
