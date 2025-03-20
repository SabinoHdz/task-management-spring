package com.springboot.app.project_task.project_task.utils.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.app.project_task.project_task.beans.ValueLabel;
import com.springboot.app.project_task.project_task.entities.catalogs.CategoryEntity;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusPriorityEntity;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusProjectEntity;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusTaskEntity;

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

    public List<ValueLabel> toStatusTaskBeanList(final List<StatusTaskEntity> statusTask) {
        if (statusTask != null && !statusTask.isEmpty()) {
            return statusTask.stream().map(this::toStatusTasktoBean).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public ValueLabel toStatusTasktoBean(final StatusTaskEntity statusTask) {
        ValueLabel bean = new ValueLabel();
        if (statusTask != null) {
            bean.setValue(statusTask.getId());
            bean.setLabel(statusTask.getName());
        }
        return bean;
    }

    public List<ValueLabel> toCategoryTaskBeanList(final List<CategoryEntity> categoryTask) {
        if (categoryTask != null && !categoryTask.isEmpty()) {
            return categoryTask.stream().map(this::toCategoryTaskBean).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public ValueLabel toCategoryTaskBean(final CategoryEntity categoryTask) {
        ValueLabel bean = new ValueLabel();
        if (categoryTask != null) {
            bean.setValue(categoryTask.getId());
            bean.setLabel(categoryTask.getName());
        }
        return bean;
    }

    public List<ValueLabel> toStatusPriorityTaskBeanList(final List<StatusPriorityEntity> statusPriority) {

        if (statusPriority != null && !statusPriority.isEmpty()) {
            return statusPriority.stream().map(this::toStatusPriorityTaskBean).collect(Collectors.toList());
        }
        return new ArrayList<>();

    }

    public ValueLabel toStatusPriorityTaskBean(StatusPriorityEntity statusPriority) {
        ValueLabel bean = new ValueLabel();
        if (statusPriority != null) {
            bean.setValue(statusPriority.getId());
            bean.setLabel(statusPriority.getName());
        }
        return bean;

    }
}
