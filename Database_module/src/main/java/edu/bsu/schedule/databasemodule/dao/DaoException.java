package edu.bsu.schedule.databasemodule.dao;

public class DaoException extends Exception{
    private static final long serialVersionUID = -1232936267707952533L;
    public DaoException(Exception ex){
        super(ex);
    }
    public DaoException(String message,Exception ex){
        super(message,ex);
    }
}
