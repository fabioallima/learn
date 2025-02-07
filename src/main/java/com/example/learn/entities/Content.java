package com.example.learn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor()
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
    private String textContent;
    private String videoUri;
}
