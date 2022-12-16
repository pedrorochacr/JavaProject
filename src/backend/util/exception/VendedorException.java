package backend.util.exception;

public class VendedorException extends Exception{
    private String msg;
    public VendedorException(String msg){
        super(msg);
    }
}
