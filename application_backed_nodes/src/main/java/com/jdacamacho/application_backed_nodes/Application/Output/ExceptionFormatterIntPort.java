package com.jdacamacho.application_backed_nodes.Application.Output;

public interface ExceptionFormatterIntPort {
    public void responseBusinessRuleViolates(String message);
    public void responseEntityNotFound(String message);
    public void responseEntityExists(String message);
    public void responseNoData(String message);
}
