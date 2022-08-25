package work.appdeploys.equipmentControlSystem.excetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import work.appdeploys.equipmentControlSystem.models.dtos.School;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SchoolExceptionBadRequest extends RuntimeException {
    public SchoolExceptionBadRequest(String message) {
        super(message);
    }
}
