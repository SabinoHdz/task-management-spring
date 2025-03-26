package com.springboot.app.project_task.project_task.utils.helper;

public enum PriorityTask {
    BACKLOG(1), IN_PROGRESS(2), FINALIZED(3), CANCEL(4);

    private final Integer value;

    PriorityTask(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    
}
