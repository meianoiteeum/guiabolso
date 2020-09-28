package br.com.guiabolso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrosExceptions {
    public static ResponseEntity duplicated(String message, String details){
        Response response = Response.duplicateEntity();
        response.addErrorMsgToResponse(details, new Exceptions.DuplicateEntityException(message));

        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }

    public static ResponseEntity notFound(String message, String details){
        Response response = Response.notFound();
        response.addErrorMsgToResponse(details, new Exceptions.EntityNotFoundException(message));

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity forbidden(String message, String details){
        Response response = Response.notFound();
        response.addErrorMsgToResponse(details, new Exceptions.ForbiddenEntityException(message));

        return new ResponseEntity(response, HttpStatus.FORBIDDEN);
    }
}
