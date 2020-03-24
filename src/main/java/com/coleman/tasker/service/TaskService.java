package com.coleman.tasker.service;

import com.coleman.tasker.domain.dto.ClaimDto;
import com.coleman.tasker.domain.dto.ListResponseDto;
import com.coleman.tasker.domain.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskService {
    Task saveMessage(Task task);
    List<Task> findAllMessages();
    ListResponseDto findCateredTasks(String username);
    Boolean claimTask(ClaimDto claimDto);
    void deleteMessage(int id);
}
