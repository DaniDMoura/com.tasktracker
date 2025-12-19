package com.tasktracker.dto;

import com.tasktracker.entity.TaskStatus;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus taskStatus
) {
}
