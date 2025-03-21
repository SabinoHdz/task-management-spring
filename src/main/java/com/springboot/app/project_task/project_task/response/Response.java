package com.springboot.app.project_task.project_task.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean show_message_in_modal;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Object data;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MessagesResponse> messages;

    
}
