package me.s3ns3iw00.chatting.exception;

import me.s3ns3iw00.chatting.model.APIResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = APIException.class)
    protected ResponseEntity<Object> handleAPIException(APIException e, WebRequest request) {
        return handleExceptionInternal(e, APIResponse.error(e.getStatus(), e.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
