package com.example.demo.controller;

import com.example.demo.beans.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/auto-grouping")
    public List<Group> autoGroup () {
        return groupService.AtuoGroup();
    }
}