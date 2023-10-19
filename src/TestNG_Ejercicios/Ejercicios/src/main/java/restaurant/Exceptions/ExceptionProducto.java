package restaurant.Exceptions;

public class ExceptionProducto extends Exception{

    /*
    * Msg (mensaje de la excepción)
    * Cause (causa subyacente)
    * .*/
    public ExceptionProducto(String msg, Throwable cause){
        super(msg,cause);
    }

    public ExceptionProducto(String msg){
        super(msg);
    };
}
