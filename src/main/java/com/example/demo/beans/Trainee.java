package com.example.demo.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    private Boolean grouped;
    @ManyToOne
    private Group group;
}
