package com.springboot.app.project_task.project_task.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.project_task.project_task.beans.ValueLabel;
import com.springboot.app.project_task.project_task.services.interfaces.CatalogService;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService serviceCatalog;


    @GetMapping("/status-project")
    public ResponseEntity getStatusProject() throws ValidationException {
        return new ResponseEntity<List<ValueLabel>>(this.serviceCatalog.getStatatusProject(), HttpStatus.OK);
    }
    @GetMapping("/status-task")
    public ResponseEntity getStatusTask() throws ValidationException {
        return new ResponseEntity<List<ValueLabel>>(this.serviceCatalog.getStatusTask(), HttpStatus.OK);
    }
    @GetMapping("/categories")
    public ResponseEntity getCategoriesProject() throws ValidationException {
        return new ResponseEntity<List<ValueLabel>>(this.serviceCatalog.getCategoriesProject(), HttpStatus.OK);
    }
    
    @GetMapping("/status-priority")
    public ResponseEntity getStatusPriority() throws ValidationException {
        return new ResponseEntity(this.serviceCatalog.getStatusPriority(), HttpStatus.OK);
    }

    // ****************implemens v2*******************
    @GetMapping("/categories-project")
    public ResponseEntity getCategoriesToProject() throws ValidationException {
        // throw new RuntimeException("Error de prueba para validar el
        // GlobalExceptionHandler");

        return new ResponseEntity(this.serviceCatalog.getCategoriesProject(),
                HttpStatus.OK);
    }
    
}
