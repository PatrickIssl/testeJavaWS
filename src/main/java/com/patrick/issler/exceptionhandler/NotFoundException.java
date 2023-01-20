package com.patrick.issler.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 2207075783989800235L;

    /**
     * Exceção personalizada para item não encontrado
     * @param msg mensagem da exceção
     */
    public NotFoundException(final String msg) {
        super(msg);
    }

}