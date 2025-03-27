package com.springboot.app.project_task.project_task.services.interfaces;

import java.util.List;

import com.springboot.app.project_task.project_task.entities.task.TaskEntity;
import com.springboot.app.project_task.project_task.utils.exceptions.BadResponseException;

import jakarta.validation.ValidationException;

public interface ITaskService {

    List<TaskEntity> getTasks() throws ValidationException;

    TaskEntity getTaskById(Integer id) throws ValidationException,BadResponseException;
    
    List<TaskEntity> getTaskByStatus(Integer id) throws ValidationException;

    List<TaskEntity> getTaskByPriority(Integer id) throws ValidationException;

     TaskEntity saveTask(TaskEntity task) throws ValidationException;
     
     TaskEntity updateTaskToStatus(Integer idTask,Integer statusTaskId) throws ValidationException,
             BadResponseException;
    
}
