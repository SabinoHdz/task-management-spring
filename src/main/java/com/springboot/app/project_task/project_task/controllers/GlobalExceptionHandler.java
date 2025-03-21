package com.springboot.app.project_task.project_task.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.app.project_task.project_task.response.MessagesResponse;
import com.springboot.app.project_task.project_task.utils.helper.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
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
    
}
