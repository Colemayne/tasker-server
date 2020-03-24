package com.coleman.tasker.domain.dto;

public class ClaimDto {
    private String taskKey;
    private String owner;

    public ClaimDto(String taskKey, String owner) {
        this.taskKey = taskKey;
        this.owner = owner;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
