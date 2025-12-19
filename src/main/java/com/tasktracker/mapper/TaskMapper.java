package com.tasktracker.mapper;

import com.tasktracker.dto.TaskCreateDTO;
import com.tasktracker.dto.TaskResponseDTO;
import com.tasktracker.entity.Task;

public interface TaskMapper {
    Task toEntity(TaskCreateDTO dto);
    TaskResponseDTO toResponse(Task task);
}
