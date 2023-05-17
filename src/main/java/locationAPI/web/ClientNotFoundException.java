package locationAPI.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ClientNotFoundException extends java.lang.Exception {
	public ClientNotFoundException(String message) {
		super(message);
	}

}
