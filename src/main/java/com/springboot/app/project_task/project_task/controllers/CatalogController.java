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

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService serviceCatalog;


    @GetMapping("/status-project")
    public ResponseEntity<List<ValueLabel>> getStatusProject(){

        return new ResponseEntity<List<ValueLabel>>(this.serviceCatalog.getStatatusProject(),HttpStatus.OK);
        
    }
    @GetMapping("/status-task")
    public String getStatusTask(){
        return "Task Status";
    }
    @GetMapping("/categories")
    public String getCategoriesProject(){
        return "Categories Project";
    }
    
    @GetMapping("/status-priority")
    public String getStatusPriority(){
        return "Priority Status";
    }
    
}
