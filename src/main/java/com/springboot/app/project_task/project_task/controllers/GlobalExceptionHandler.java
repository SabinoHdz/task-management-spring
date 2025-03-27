package com.springboot.app.project_task.project_task.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.springboot.app.project_task.project_task.response.MessagesResponse;
import com.springboot.app.project_task.project_task.utils.exceptions.BadResponseException;
import com.springboot.app.project_task.project_task.utils.helper.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ResponseUtil responseUtil;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerExceptionV(Exception e){

    List<MessagesResponse>  mensajes= new ArrayList<>();
    mensajes.add(new MessagesResponse("Apreciable usuario","Ocurrio un error inesperado"));
     log.info("Se ha generado un error inesperado",e);   
    return responseUtil.badResponse(true, mensajes, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BadResponseException.class)
    public ResponseEntity<Object> handlerExceptionV(BadResponseException e) {

        if (e.getErrorCode() == 400 || e.getErrorCode() == 404) {
            return responseUtil.badResponse(e.getShow_message_in_modal(), e.getMessages(),
                    e.getErrorCode() == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.status(e.getErrorCode()).body(null);
    }

    // captura de errores de validacion
    // campos requeridos
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handlerExceptionV(MissingServletRequestParameterException e) {
        List<MessagesResponse> messages = new ArrayList<>();
        messages.add(new MessagesResponse("Parametros y/o body requerido", e.getMessage()));
        return responseUtil.badResponse(false, messages, HttpStatus.BAD_REQUEST);
    }

    // captura de errores de validacion
    // el tipo de dato no corresponde
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        List<MessagesResponse> messages = new ArrayList<>();
        messages.add(new MessagesResponse("Error en el tipo de dato", ex.getMessage()));
        return responseUtil.badResponse(false, messages, HttpStatus.BAD_REQUEST);
    }

    // RUTA NO ENCONTRADA
    @ExceptionHandler({ NoHandlerFoundException.class, NoResourceFoundException.class })
    public ResponseEntity<Object> handlerExceptionV(NoHandlerFoundException e) {
        List<MessagesResponse> messages = new ArrayList<>();
        messages.add(new MessagesResponse("Ruta no encontrada", e.getMessage()));
        return responseUtil.badResponse(false, messages, HttpStatus.BAD_REQUEST);
    }

}
