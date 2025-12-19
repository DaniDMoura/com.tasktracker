package com.tasktracker.mapper;

import com.tasktracker.dto.TaskCreateDTO;
import com.tasktracker.dto.TaskResponseDTO;
import com.tasktracker.entity.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper{
    @Override
    public Task toEntity(TaskCreateDTO dto) {
        Task task = new Task();

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setTaskStatus(dto.taskStatus());

        return task;
    }

    @Override
    public TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getTaskStatus()
        );
    }
}
