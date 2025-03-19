package com.springboot.app.project_task.project_task.utils.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.app.project_task.project_task.beans.ValueLabel;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusProjectEntity;

@Component
public class CatalogHelper {
    public List<ValueLabel> toStatusProjectBeanList(final List<StatusProjectEntity> statusProject){
        if (statusProject!=null && !statusProject.isEmpty()) {
            return  statusProject.stream().map(this::toStatusProjectBean).collect(Collectors.toList());
        }
        return new ArrayList<>();
        
    }
    public ValueLabel toStatusProjectBean(final StatusProjectEntity statusProject){
        ValueLabel bean= new ValueLabel();
        if (statusProject!=null) {
            bean.setLabel(statusProject.getName());
            bean.setValue(statusProject.getId());
        }
        return bean;
    }
}
