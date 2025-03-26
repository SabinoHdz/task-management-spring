package com.springboot.app.project_task.project_task.services.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.project_task.project_task.entities.task.TaskEntity;
import com.springboot.app.project_task.project_task.repositories.task.ITaskRepository;
import com.springboot.app.project_task.project_task.response.MessagesResponse;
import com.springboot.app.project_task.project_task.services.interfaces.ITaskService;
import com.springboot.app.project_task.project_task.utils.exceptions.BadResponseException;
import com.springboot.app.project_task.project_task.utils.helper.PrioritySatatus;
import com.springboot.app.project_task.project_task.utils.helper.PriorityTask;

import jakarta.validation.ValidationException;

@Service
public class TaskServiceImpl implements ITaskService {
    private String titleDefault="Información no encontrada";
    private String descriptionDefault="No fue posible obtener la información solicitada.";
    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public List<TaskEntity> getTasks() throws ValidationException {
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity getTaskById(Integer id) throws ValidationException, BadResponseException { 
    
    Optional<TaskEntity> taskOptional=taskRepository.findById(id);

    if (!taskOptional.isPresent()) {
        
        List<MessagesResponse> messages =new ArrayList<>();
        messages.add(new MessagesResponse(titleDefault,descriptionDefault+" La tarea  no fue encontrada."));
        throw new BadResponseException(true,messages,404);
    }


    return taskOptional.get();
    }

    @Override
    public TaskEntity saveTask(TaskEntity task) throws ValidationException {
       
        return taskRepository.save(validateData(task));
    }

    @Override
    public List<TaskEntity> getTaskByPriority(Integer id) throws ValidationException {
       
        return taskRepository.findByPriorityId(id);
    }

    @Override
    public List<TaskEntity> getTaskByStatus(Integer id) throws ValidationException {
        return taskRepository.findByStatusTaskId(id);
    }

    @Override
    @Transactional
    public TaskEntity updateTaskToStatus( Integer idTask, Integer statusTaskId) throws ValidationException,BadResponseException {
        
       TaskEntity task= getTaskById(idTask);
       
       if (task.getStatusTaskId().equals(PriorityTask.FINALIZED.getValue())) {
        List<MessagesResponse> messages =new ArrayList<>();
        messages.add(new MessagesResponse(titleDefault,descriptionDefault+" La tarea ya se encuentra finalizada."));
        throw new BadResponseException(true,messages,400);
       }else 
       if (statusTaskId.equals(PriorityTask.FINALIZED.getValue()))     {
        task.setCompleted(Boolean.TRUE);
       }{

       }
       
       task.setStatusTaskId(statusTaskId);
        
        return taskRepository.save(task);
    }

    private TaskEntity validateData(TaskEntity data){

        if (data.getPriorityId()==null) {
        data.setPriorityId(PrioritySatatus.LOW.getValue());
        
        }
        if (data.getStatusTaskId()==null) {
            data.setStatusTaskId( PriorityTask.BACKLOG.getValue());
            
        }
        // if (data.getCreated_at()==null) {
        //     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //     Date date = new Date();
        //     try {
        //         data.setCreated_at( formatter.parse( formatter.format(date)));
        //     } catch (ParseException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
            
        // }
        return data;
    }

   
 

    
}
