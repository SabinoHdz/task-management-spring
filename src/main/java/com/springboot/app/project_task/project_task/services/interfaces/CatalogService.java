package com.springboot.app.project_task.project_task.services.interfaces;

import java.util.List;

import com.springboot.app.project_task.project_task.beans.ValueLabel;

import jakarta.validation.ValidationException;

public interface CatalogService {
    List<ValueLabel> getStatatusProject() throws ValidationException;

    List<ValueLabel> getStatusTask() throws ValidationException;

    List<ValueLabel> getCategoriesProject() throws ValidationException;

    List<ValueLabel> getStatusPriority() throws ValidationException;

    /************* Version 2 *********************/
    List<ValueLabel> getCategories() throws ValidationException;
}
