package com.springboot.app.project_task.project_task.utils.helper;

public enum PrioritySatatus {
    LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);
    
    private final Integer value;
    
    PrioritySatatus(Integer value){
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
