package br.com.erudio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends  RuntimeException {

    public UnsupportedMathOperationException(String ex) {
        super(ex);
    }

    private static final long serializable = 1L;
}