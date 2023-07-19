package com.gamedoora.backend.userservices.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author aprajshekhar
 */
@ControllerAdvice
public class GamedooraExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {NotFoundException.class})
  protected ResponseEntity<Object> handleNotFound(NotFoundException ex, WebRequest request) {
    GamedooraExceptionResponseEntity bodyOfResponse =
        GamedooraExceptionResponseEntity.builder()
            .status(HttpStatus.NOT_FOUND.name())
            .message(ex.getMessage())
            .details(ex.getMessage())
            .build();
    return handleExceptionInternal(
        ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
}
