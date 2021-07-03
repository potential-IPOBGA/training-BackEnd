package com.example.demo.beans;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "teams") //todo 默认名 group, 连表都创建不了，我在微信群都提示这个事情了
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Trainer> trainers;
    @OneToMany(mappedBy = "group")
    private List<Trainee> trainees;

}
