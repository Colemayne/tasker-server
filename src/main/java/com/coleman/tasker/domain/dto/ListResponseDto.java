package com.coleman.tasker.domain.dto;

import com.coleman.tasker.domain.model.Task;

import java.util.List;

public class ListResponseDto {
    private List<Task> myClaimedTasks;
    private List<Task> otherClaimedTasks;
    private List<Task> unclaimedTasks;

    public ListResponseDto(List<Task> myClaimedTasks, List<Task> otherClaimedTasks, List<Task> unclaimedTasks) {
        this.myClaimedTasks = myClaimedTasks;
        this.otherClaimedTasks = otherClaimedTasks;
        this.unclaimedTasks = unclaimedTasks;
    }

    public List<Task> getMyClaimedTasks() {
        return myClaimedTasks;
    }

    public void setMyClaimedTasks(List<Task> myClaimedTasks) {
        this.myClaimedTasks = myClaimedTasks;
    }

    public List<Task> getOtherClaimedTasks() {
        return otherClaimedTasks;
    }

    public void setOtherClaimedTasks(List<Task> otherClaimedTasks) {
        this.otherClaimedTasks = otherClaimedTasks;
    }

    public List<Task> getUnclaimedTasks() {
        return unclaimedTasks;
    }

    public void setUnclaimedTasks(List<Task> unclaimedTasks) {
        this.unclaimedTasks = unclaimedTasks;
    }
}
