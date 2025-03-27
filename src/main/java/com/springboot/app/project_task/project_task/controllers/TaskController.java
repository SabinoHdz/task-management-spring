package com.springboot.app.project_task.project_task.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.project_task.project_task.entities.task.TaskEntity;
import com.springboot.app.project_task.project_task.services.impl.TaskServiceImpl;
import com.springboot.app.project_task.project_task.utils.exceptions.BadResponseException;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping() 
    public List<TaskEntity> getAllTasks(){
        return taskService.getTasks();
    }
    @GetMapping("/query")
    public TaskEntity getTaskById(@RequestParam Integer id)  throws ValidationException,BadResponseException{
        return  taskService.getTaskById(id);
    }

    @GetMapping("/get-task-by-priority")
    public List<TaskEntity>  getTaskByPriority( @RequestParam Integer id){
        return taskService.getTaskByPriority(id);
    }
    @GetMapping("/get-task-by-status")
    public List<TaskEntity>  getTaskByStatus( @RequestParam Integer id){
        return taskService.getTaskByStatus(id);
    }
    @PostMapping("/create")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        TaskEntity taskDto= new TaskEntity();
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriorityId(task.getPriorityId());
        //taskDto.setStatusTask(task.getStatusTask());
        taskDto.setStatusTaskId(task.getStatusTaskId());
        taskDto.setActive(Boolean.TRUE);
        task.setCompleted(Boolean.FALSE);
        task.setCreated_at(task.getCreated_at());
        return taskService.saveTask(task);
    }

    @PostMapping("/update-progress")
    public TaskEntity updateStatus(@RequestParam Integer idTask,@RequestParam Integer status) throws ValidationException,BadResponseException{
    TaskEntity taskUpdated=taskService.updateTaskToStatus(idTask, status);
    return taskUpdated;
    }

}
