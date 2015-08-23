package edu.bsu.schedule.service;

public class ServiceException extends Exception{
    private static final long serialVersionUID = -1232936267707952533L;
    public ServiceException(Exception ex){
        super(ex);
    }
    public ServiceException(String message,Exception ex){
        super(message,ex);
    }
}
