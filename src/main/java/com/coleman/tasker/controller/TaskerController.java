package com.coleman.tasker.controller;

import com.coleman.tasker.domain.dto.ClaimDto;
import com.coleman.tasker.domain.dto.ListResponseDto;
import com.coleman.tasker.domain.model.Task;
import com.coleman.tasker.service.TaskService;
import com.coleman.tasker.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/tasker/v1")
public class TaskerController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RandomUtils randomUtils;

    @RequestMapping(path = "/alive", method = RequestMethod.GET)
    public ResponseEntity<String> alive() {
        return ResponseEntity.ok().body("alive");
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<Task> saveMessage(@RequestBody Task task) {
        LocalDateTime now = LocalDateTime.now();
        String tkey = randomUtils.randomCharacters(10);
        task.setTime(now);
        task.setTaskKey(tkey);
        return ResponseEntity.ok().body(taskService.saveMessage(task));
    }

    @RequestMapping(path = "/claim", method = RequestMethod.POST)
    public ResponseEntity<Boolean> claimTask(@RequestBody ClaimDto claimDto) {
        return ResponseEntity.ok().body(taskService.claimTask(claimDto));
    }

    @RequestMapping(path = "/select/{username}", method = RequestMethod.GET)
    public ResponseEntity<ListResponseDto> getMessages(@PathVariable String username){
        return ResponseEntity.ok().body(taskService.findCateredTasks(username));
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMessage(@PathVariable Integer id) {
        try {
            taskService.deleteMessage(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }




}
