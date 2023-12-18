package com.uybor.entity.template;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class AbcNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 1000)
    private String name;
}
