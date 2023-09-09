package org.symbolBackEnd.exception;
/*
  @author emilia
  @project SymbolProject
  @class DatabaseFetchException
  @version 1.0.0
  @since 09.09.2023 - 12:12
*/

public class DatabaseFetchException extends RuntimeException {
    public DatabaseFetchException(String message){
        super(message);
    }
    public DatabaseFetchException(Integer integer, String message){
        super(message);
    }
}
