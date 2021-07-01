package com.example.demo.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TraineeResponse {
    private Long id;
    private String name;
}
