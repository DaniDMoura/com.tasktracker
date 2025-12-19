package com.tasktracker.dto;

import com.tasktracker.entity.TaskStatus;

public record TaskCreateDTO(
        String title,
        String description,
        TaskStatus taskStatus
) {}
