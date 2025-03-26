package com.springboot.app.project_task.project_task.utils.exceptions;

import java.util.List;

import com.springboot.app.project_task.project_task.response.MessagesResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BadResponseException  extends Exception{
    private Boolean show_message_in_modal;
    private List<MessagesResponse> messages;
    private Integer errorCode;
}
