package com.springboot.app.project_task.project_task.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.project_task.project_task.beans.ValueLabel;
import com.springboot.app.project_task.project_task.repositories.catalogs.ITiposCategoriaRepository;
import com.springboot.app.project_task.project_task.repositories.catalogs.ITiposEstatusProyectoRepository;
import com.springboot.app.project_task.project_task.repositories.catalogs.ITiposEstatusTareaRepository;
import com.springboot.app.project_task.project_task.repositories.catalogs.ITiposPrioridadRepository;
import com.springboot.app.project_task.project_task.services.interfaces.CatalogService;
import com.springboot.app.project_task.project_task.utils.helper.CatalogHelper;

import jakarta.validation.ValidationException;

@Service
public class CatalogServiceImpl implements CatalogService  {
    @Autowired 
    private ITiposEstatusProyectoRepository repoStatusProject;
    @Autowired
    private ITiposEstatusTareaRepository repoStatusTask;

    @Autowired
    private ITiposCategoriaRepository repoCategoryTask;

    @Autowired
    private ITiposPrioridadRepository repoPriorityTask;

    @Autowired
    private CatalogHelper helper;


    @Override
    public List<ValueLabel> getStatatusProject() {
        return this.helper.toStatusProjectBeanList(repoStatusProject.findAll());
    }

    @Override
    public List<ValueLabel> getStatusTask() {
        return this.helper.toStatusTaskBeanList(repoStatusTask.findAll());
    }

    @Override
    public List<ValueLabel> getCategoriesProject() {
        return this.helper.toCategoryTaskBeanList(repoCategoryTask.findAll());
    }

    @Override
    public List<ValueLabel> getStatusPriority() {
        return this.helper.toStatusPriorityTaskBeanList(repoPriorityTask.findAll());
    }

    // ****************implemens v2*******************
    @Override
    public List<ValueLabel> getCategories() throws ValidationException {
        try {
            return this.helper.toCategoryTaskBeanList(repoCategoryTask.findAll());
        } catch (Exception e) {
            throw e;
        }
    }

}
