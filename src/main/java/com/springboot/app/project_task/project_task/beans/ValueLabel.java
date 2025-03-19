package com.springboot.app.project_task.project_task.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ValueLabel implements Serializable{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int value;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String label;

    
}
