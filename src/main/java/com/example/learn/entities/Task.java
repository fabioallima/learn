package com.example.learn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor()
@Entity
@Table(name = "tb_task")
public class Task extends Lesson{
    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;
}
