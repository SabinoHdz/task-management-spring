package com.springboot.app.project_task.project_task.services.interfaces;

import java.util.List;

import com.springboot.app.project_task.project_task.beans.ValueLabel;

import jakarta.validation.ValidationException;

public interface CatalogService {
    List<ValueLabel> getStatatusProject();

    List<ValueLabel> getStatusTask();

    List<ValueLabel> getCategoriesProject();

    List<ValueLabel> getStatusPriority();

    /************* Version 2 *********************/
    List<ValueLabel> getCategories() throws ValidationException;
}
