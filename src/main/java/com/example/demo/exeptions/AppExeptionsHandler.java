package ws.exeptions;
import ControllerAdvice;
import ExceptionHandler;
import HttpHeaders;
import WebRequest;
import ResponseEntity;
import ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExtensionsHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler( value = {Exception.class})
    public ResponseEntity<Object> handleAnyException( Exception ex, WebRequest request){
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}