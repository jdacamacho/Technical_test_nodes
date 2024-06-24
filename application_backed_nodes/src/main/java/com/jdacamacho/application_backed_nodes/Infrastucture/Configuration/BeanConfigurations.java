package com.jdacamacho.application_backed_nodes.Infrastucture.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdacamacho.application_backed_nodes.Application.Output.ExceptionFormatterIntPort;
import com.jdacamacho.application_backed_nodes.Application.Output.ManageCoordinateGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Application.Output.ManageNodeGatewayIntPort;
import com.jdacamacho.application_backed_nodes.Domain.UseCases.ManageNodeCUImplAdapter;
import com.jdacamacho.application_backed_nodes.Infrastucture.Input.ErrorCatcher;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public ManageNodeCUImplAdapter createNode(ManageNodeGatewayIntPort gatewayNode,
                                                ManageCoordinateGatewayIntPort gatewayCooordinate,
                                                ExceptionFormatterIntPort exceptionFormatter){
        return new ManageNodeCUImplAdapter(gatewayNode,gatewayCooordinate,exceptionFormatter);
    }

    @Bean
    public ErrorCatcher createErrorCatcher(){
        return new ErrorCatcher();
    }
}
