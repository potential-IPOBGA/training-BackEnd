package com.example.demo.beans;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Group {
    private Long id;
    private String name;

}
