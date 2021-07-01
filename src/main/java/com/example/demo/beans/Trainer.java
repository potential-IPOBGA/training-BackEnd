package com.example.demo.beans;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trainer {
    private Long id;
    @NotBlank
    private String name;
    private Long groupId;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}
