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

        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessageDescription = new ErrorMessage(new Date(), errorMessageDescription);
    
        return new ResponseEntity<>(
            errorMessageDescription, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler( value = {errorMessageDescription.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificPointerExceptions(  Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessageDescription = new ErrorMessage(new Date(), errorMessageDescription);
    
        return new ResponseEntity<>(
            errorMessageDescription, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}