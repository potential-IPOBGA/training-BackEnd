package com.example.demo.service;

import com.example.demo.beans.Group;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();

    List<Group> autoGroup ();
}
