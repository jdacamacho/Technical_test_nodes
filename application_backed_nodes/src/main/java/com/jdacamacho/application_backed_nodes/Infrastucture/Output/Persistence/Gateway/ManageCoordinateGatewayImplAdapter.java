package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Gateway;

import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Output.ManageCoordinateGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.Persistence.Repositories.CoordinateRepository;

@Service
public class ManageCoordinateGatewayImplAdapter implements ManageCoordinateGatewayIntPort {
    private final CoordinateRepository serviceBD;

    public ManageCoordinateGatewayImplAdapter(CoordinateRepository serviceBD){
        this.serviceBD = serviceBD;
    }

    @Override
    public boolean existsByCoordinates(double valueX, double valuey) {
        return this.serviceBD.existsByValueXAndValueY(valueX, valuey);
    }
    
}
