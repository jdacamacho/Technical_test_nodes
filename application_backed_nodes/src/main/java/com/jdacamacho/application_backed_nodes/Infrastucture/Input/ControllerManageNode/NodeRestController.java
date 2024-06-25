package com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdacamacho.application_backed_nodes.Application.Input.ManageNodeCUIntPort;
import com.jdacamacho.application_backed_nodes.Application.Input.MapperNodeInfrastructureDomainIntPort;
import com.jdacamacho.application_backed_nodes.Domain.Models.Node;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ErrorCatcher;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTORequest.NodeDTORequest;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ControllerManageNode.DTOResponse.NodeDTOResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/nodes")
@Validated
@RequiredArgsConstructor
public class NodeRestController {
    private final ManageNodeCUIntPort nodeCU;
    private final MapperNodeInfrastructureDomainIntPort mapper;
    private final ErrorCatcher errorCatcher;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<NodeDTOResponse>> index(){
        List<Node> nodes = this.nodeCU.listNodes();

        return new ResponseEntity<List<NodeDTOResponse>>(
            this.mapper.mapModelToResponse(nodes), HttpStatus.OK);
    }

    @GetMapping("/name/")
    @Transactional(readOnly = true)
    public ResponseEntity<List<NodeDTOResponse>> indexByName(@RequestParam String name){
        List<Node> nodes = this.nodeCU.listNodesByName(name);

        return new ResponseEntity<List<NodeDTOResponse>>(
            this.mapper.mapModelToResponse(nodes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<NodeDTOResponse> getById(@PathVariable long id){
        Node node = this.nodeCU.getNodeById(id);

        return new ResponseEntity<NodeDTOResponse>(
            this.mapper.mapModelToResponse(node), HttpStatus.OK);
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<?> createNode(@Valid @RequestBody NodeDTORequest request, 
                                        BindingResult result ){

        Node node = this.mapper.mapRequestToModel(request);

        Map<String, Object> response = new HashMap<>();
        response = this.errorCatcher.catchErrors(result);

        if(response.size() != 0){
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }

        try {
            NodeDTOResponse objNode = this.mapper.mapModelToResponse(this.nodeCU.createNode(node));
            return new ResponseEntity<NodeDTOResponse>(objNode, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("message", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateNode(@PathVariable long id ,
                                        @Valid @RequestBody NodeDTORequest request, 
                                        BindingResult result ){

        Node node = this.mapper.mapRequestToModel(request);

        Map<String, Object> response = new HashMap<>();
        response = this.errorCatcher.catchErrors(result);

        if(response.size() != 0){
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }

        try {
            NodeDTOResponse objNode = this.mapper.mapModelToResponse(this.nodeCU.updateNode(id, node));
            return new ResponseEntity<NodeDTOResponse>(objNode, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("message", "Error when updating into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteNode(@PathVariable long id) {
        
        try {
            boolean flagDeleted = this.nodeCU.deleteNode(id);
            return ResponseEntity.ok(flagDeleted);
        } catch (DataAccessException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error deleting in database");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
