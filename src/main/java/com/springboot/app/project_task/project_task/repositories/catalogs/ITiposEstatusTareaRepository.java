package com.springboot.app.project_task.project_task.repositories.catalogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.project_task.project_task.entities.catalogs.StatusTaskEntity;

@Repository
public interface ITiposEstatusTareaRepository extends JpaRepository<StatusTaskEntity,Integer>  {
    
}
