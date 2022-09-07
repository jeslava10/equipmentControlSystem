package work.appDeploys.equipmentControlSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SchoolExceptionInternalError extends RuntimeException {
    public SchoolExceptionInternalError(String message) {
        super(message);
    }
}