package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 从 final-quiz 的表现来看：
 * 1. 持久层框架使用的不熟练，无论是 jpa 还是 MyBatis，在这个上面也浪费了很多的时间，
 *    切回 jpa 之后，建表也失败了，估计也没怎么测试
 * 2. @OneToMany, @ManyToOne 掌握的不好，只会最简单的单表操作，联表操作就拉跨，下来下点功夫搞明白
 * 3. 整体的代码规范不错，结构也不错，比上一次进步了一点。
 * 4. docker 部分的完成度较高
 *
 * 整体表现：
 * 1. 态度积极，勤学好问，理解能力也不错
 * 2. code review 也能够提出自己的问题与观点，能看出还是下了功夫的。
 *
 * 建议：
 * 整体表现不错，但是还是要再踏实一点，把 jpa, mybatis 搞明白，不能遇到稍微难一点的就搞不出来了。
 *
 * Good luck, bro !
 */
@SpringBootApplication
public class FinalQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalQuizApplication.class, args);
	}

}
