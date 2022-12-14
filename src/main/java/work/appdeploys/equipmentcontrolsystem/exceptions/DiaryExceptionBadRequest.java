package work.appdeploys.equipmentcontrolsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiaryExceptionBadRequest extends RuntimeException {
    public DiaryExceptionBadRequest(String message) {
        super(message);
    }

}
