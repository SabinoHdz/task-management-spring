package com.springboot.app.project_task.project_task.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.project_task.project_task.beans.ValueLabel;
import com.springboot.app.project_task.project_task.repositories.catalogs.ITiposEstatusProyectoRepository;
import com.springboot.app.project_task.project_task.services.interfaces.CatalogService;
import com.springboot.app.project_task.project_task.utils.helper.CatalogHelper;

@Service
public class CatalogServiceImpl implements CatalogService  {
    @Autowired 
    private ITiposEstatusProyectoRepository repoStatusProject;

    @Autowired
    private CatalogHelper helper;


    @Override
    public List<ValueLabel> getStatatusProject() {
        return this.helper.toStatusProjectBeanList(repoStatusProject.findAll());
    }
    
}
