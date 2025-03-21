package com.springboot.app.project_task.project_task.response;

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
public class MessagesResponse implements Serializable {
   
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
}
    

