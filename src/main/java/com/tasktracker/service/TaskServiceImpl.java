package com.tasktracker.service;


import com.tasktracker.dto.TaskCreateDTO;
import com.tasktracker.dto.TaskResponseDTO;
import com.tasktracker.entity.Task;
import com.tasktracker.exception.TaskNotFoundException;
import com.tasktracker.mapper.TaskMapper;
import com.tasktracker.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskResponseDTO> findAll(){
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponseDTO findById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + id));

        return taskMapper.toResponse(task);
    }

    @Override
    @Transactional
    public TaskResponseDTO createTask(TaskCreateDTO taskDTO){
        Task task = taskRepository.save(taskMapper.toEntity(taskDTO));

        return taskMapper.toResponse(task);
    }

    @Override
    @Transactional
    public TaskResponseDTO updateTask(Long id, TaskCreateDTO newTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + id));

        task.setTitle(newTask.title());
        task.setDescription(newTask.description());
        task.setTaskStatus(newTask.taskStatus());

        return taskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + id));

        taskRepository.delete(task);
    }
}
