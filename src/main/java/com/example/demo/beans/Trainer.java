package com.example.demo.beans;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Trainer {
    private Long id;
    @NotBlank
    private String name;
    private Long groupId;
}
