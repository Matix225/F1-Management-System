package F1.Clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class TeamsServiceUnavailableException extends RuntimeException {
    public TeamsServiceUnavailableException(Throwable cause){
        super("Teams service is unavailable", cause);
    }
}
