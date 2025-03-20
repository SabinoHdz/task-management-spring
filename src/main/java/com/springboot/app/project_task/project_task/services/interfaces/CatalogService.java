package com.springboot.app.project_task.project_task.services.interfaces;

import java.util.List;

import com.springboot.app.project_task.project_task.beans.ValueLabel;

public interface CatalogService {
    List<ValueLabel> getStatatusProject();

    List<ValueLabel> getStatusTask();

    List<ValueLabel> getCategoriesProject();

    List<ValueLabel> getStatusPriority();
}
