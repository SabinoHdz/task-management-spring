package com.springboot.app.project_task.project_task.utils.helper;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.springboot.app.project_task.project_task.response.MessagesResponse;
import com.springboot.app.project_task.project_task.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseUtil {

    public ResponseEntity badResponse(Boolean show_modal,List<MessagesResponse>messages,HttpStatus status){
        return new ResponseEntity<>(new Response(show_modal,null,messages),status);
    }
    
}
