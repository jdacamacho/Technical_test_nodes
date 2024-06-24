package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Gateway;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Output.ManageCoordinateGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Repositories.CoordinateRepository;

@Service
public class ManageCoordinateGatewayImplAdapter implements ManageCoordinateGatewayIntPort {
    private final CoordinateRepository serviceBD;
    private final ModelMapper mapper;

    public ManageCoordinateGatewayImplAdapter(CoordinateRepository serviceBD,
                                                ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public boolean existsByCoordinates(double valueX, double valuey) {
        return this.serviceBD.existsByValueXAndValueY(valueX, valuey);
    }
    
}
