package com.github.azharjk.joane.exception;

import com.github.azharjk.joane.utils.JoaneResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public JoaneResponse<String, Void> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
    return new JoaneResponse<>(ex.getBody().getDetail(), null);
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(BadCredentialsException.class)
  public JoaneResponse<String, Void> badCredentialsException(BadCredentialsException ex) {
    return new JoaneResponse<>(ex.getMessage(), null);
  }
}
