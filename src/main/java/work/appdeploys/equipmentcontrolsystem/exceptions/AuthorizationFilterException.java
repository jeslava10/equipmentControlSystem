package work.appdeploys.equipmentcontrolsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AuthorizationFilterException extends RuntimeException{
    public AuthorizationFilterException(String message) {
        super(message);
    }
}
