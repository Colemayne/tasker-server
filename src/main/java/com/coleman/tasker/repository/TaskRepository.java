package com.coleman.tasker.repository;

import com.coleman.tasker.domain.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {
  Task findById(int id);
  Task findByTaskKey(String taskKey);
  List<Task> findAll();
}
