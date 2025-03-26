package com.springboot.app.project_task.project_task.repositories.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.project_task.project_task.entities.task.TaskEntity;
import java.util.List;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusTaskEntity;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusPriorityEntity;



@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity,Integer>  {
    
    // <Optional> TaskEntity findById(Integer id);
    List<TaskEntity> findByPriorityId(Integer priorityId);
    List<TaskEntity> findByStatusTaskId(Integer statusTaskId);
     
}
