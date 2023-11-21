package br.com.gitobank.exception;

public class DBException extends Exception{

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DBException(String message) {
        super(message);
    }

    public DBException( Throwable cause) {
        super(cause);
    }


}
