package com.springboot.app.project_task.project_task.entities.task;

import java.util.Date;

import com.springboot.app.project_task.project_task.entities.catalogs.StatusPriorityEntity;
import com.springboot.app.project_task.project_task.entities.catalogs.StatusTaskEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "task")
public class TaskEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @Column(name = "status_priority")
    private Integer priorityId;

    @Column(name = "status_task")
    private Integer statusTaskId;
    
    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;
    private Boolean active;
    private Boolean  completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name ="status_priority",referencedColumnName = "id",  insertable = false,updatable = false,nullable = true)
    private  StatusPriorityEntity priority;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="status_task",referencedColumnName ="id" ,insertable = false,updatable = false,nullable = true)
    private  StatusTaskEntity  statusTask;

    
}
