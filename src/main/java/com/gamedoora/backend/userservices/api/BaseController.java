package com.gamedoora.backend.userservices.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1")
@CrossOrigin("*")
public abstract class BaseController {
  public <T> ResponseEntity<T>  createResponse(T entity, HttpStatus httpStatus){
    if(null == entity){
      return new ResponseEntity<>(httpStatus);
    }
    return new ResponseEntity<>(entity, httpStatus);
  }
}
