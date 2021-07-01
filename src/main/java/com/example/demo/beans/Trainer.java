package com.example.demo.beans;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Trainer {
    private Long id;
    private String name;
    private Long groupId;
}
