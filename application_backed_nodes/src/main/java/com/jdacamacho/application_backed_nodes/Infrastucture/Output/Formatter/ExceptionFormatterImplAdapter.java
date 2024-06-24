package com.jdacamacho.application_backed_nodes.Infrastucture.Output.Formatter;

import org.springframework.stereotype.Service;

import com.jdacamacho.application_backed_nodes.Application.Output.ExceptionFormatterIntPort;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.ExceptionHandler.OwnException.EntityExistsException;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.ExceptionHandler.OwnException.EntityNotFoundException;
import com.jdacamacho.application_backed_nodes.Infrastucture.Output.ExceptionHandler.OwnException.NoDataException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort {

    @Override
    public void responseBusinessRuleViolates(String message) {
        throw new BusinessRuleException(message);
    }

    @Override
    public void responseEntityNotFound(String message) {
        throw new EntityNotFoundException(message);
    }

    @Override
    public void responseEntityExists(String message) {
        throw new EntityExistsException(message);
    }

    @Override
    public void responseNoData(String message) {
        throw new NoDataException(message);
    }
    
}
