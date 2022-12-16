package backend.util.exception;

public class GerenteException extends Exception{
    private String msg;
    public GerenteException(String msg){
        super(msg);
    }
}
