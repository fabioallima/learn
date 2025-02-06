package com.example.learn.entities;

import com.example.learn.entities.enums.ResourceTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceTypeEnum type;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
