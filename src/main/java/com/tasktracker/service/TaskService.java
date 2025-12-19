package com.tasktracker.service;

import com.tasktracker.dto.TaskCreateDTO;
import com.tasktracker.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> findAll();
    TaskResponseDTO findById(Long id);
    TaskResponseDTO createTask(TaskCreateDTO task);
    TaskResponseDTO updateTask(Long id, TaskCreateDTO task);
    void deleteTask(Long Id);

}
