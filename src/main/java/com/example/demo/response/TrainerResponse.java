package com.example.demo.response;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TrainerResponse {
    private Long id;
    private String name;
}
