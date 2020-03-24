package com.coleman.tasker.service;

import com.coleman.tasker.domain.dto.ClaimDto;
import com.coleman.tasker.domain.dto.ListResponseDto;
import com.coleman.tasker.domain.model.Task;
import com.coleman.tasker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveMessage(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllMessages() {
        return taskRepository.findAll();
    }

    @Override
    public ListResponseDto findCateredTasks(String username) {

        List<Task> myClaimedTasks = new ArrayList<>();
        List<Task> otherClaimedTasks = new ArrayList<>();
        List<Task> unclaimedTasks = new ArrayList<>();

        List<Task> allTasks = taskRepository.findAll();

        for(Task task: allTasks) {
            if(task.getOwner().isEmpty()){
                unclaimedTasks.add(task);
            } else if(task.getOwner().equals(username)) {
                myClaimedTasks.add(task);
            } else {
                otherClaimedTasks.add(task);
            }
        }

        return new ListResponseDto(myClaimedTasks,otherClaimedTasks,unclaimedTasks);

    }

    @Override
    public Boolean claimTask(ClaimDto claimDto) {
        Task task = taskRepository.findByTaskKey(claimDto.getTaskKey());
        // Only claim a task.
        if(!task.getOwner().equals(claimDto.getOwner())) {
            task.setOwner(claimDto.getOwner());
            taskRepository.save(task);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public void deleteMessage(int id){
        taskRepository.deleteById(id);
    }


}
