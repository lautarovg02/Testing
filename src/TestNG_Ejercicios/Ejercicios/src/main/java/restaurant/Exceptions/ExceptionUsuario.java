package restaurant.Exceptions;

public class ExceptionUsuario extends Exception{
    public ExceptionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    public  ExceptionUsuario(String msg, Throwable cause){
        super(msg, cause);
    }
}
