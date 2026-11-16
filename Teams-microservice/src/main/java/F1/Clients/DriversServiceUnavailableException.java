package F1.Clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class DriversServiceUnavailableException extends RuntimeException {
    public DriversServiceUnavailableException(Throwable cause){
        super("Drivers service is unavailable", cause);
    }
}
