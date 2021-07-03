package com.example.demo.service.impl;

import com.example.demo.beans.Group;
import com.example.demo.beans.Trainee;
import com.example.demo.beans.Trainer;
import com.example.demo.exception.TrainerNumberException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TraineeRepository traineeRepository;


    @Override
    public List<Group> getGroups()  {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> autoGroup () {
        List<Group> allGroup = groupRepository.findAll();
        List<Trainee> allTrainees = traineeRepository.findAll();
        List<Trainer> allTrainers = trainerRepository.findAll();
        if ((long) allTrainers.size() < 2) {
            throw new TrainerNumberException();
        }
        shuffleAllLists(allGroup, allTrainees, allTrainers);
        int groupSize = (int)Math.floor(allTrainees.size() / 2.0);
        groupTrainees(allGroup, allTrainees, groupSize);
        groupTrainers(allGroup, allTrainers, groupSize);
        saveGroup(allGroup);

        return groupRepository.findAll();
    }

    private void saveGroup (List<Group> allGroup) {
        for(Group group : allGroup) {
            groupRepository.save(group);
        }
    }

    private void groupTrainers (List<Group> allGroup, List<Trainer> allTrainers, int groupSize) {
        for (int i = 0; i < allTrainers.size(); i++) {
            allGroup.get(i % groupSize).getTrainers().add(allTrainers.get(i));
            allTrainers.get(i).setGrouped(true);
            trainerRepository.save(allTrainers.get(i));
        }
    }

    private void groupTrainees (List<Group> allGroup, List<Trainee> allTrainees, int groupSize) {
        for (int i = 0; i < allTrainees.size(); i++) {
            //todo 下面一行数组越界，原因 自己找
            allGroup.get(i % groupSize).getTrainees().add(allTrainees.get(i));
            allTrainees.get(i).setGrouped(true);
            traineeRepository.save(allTrainees.get(i));
        }
    }

    private void shuffleAllLists (List<Group> allGroup, List<Trainee> allTrainees, List<Trainer> allTrainers) {
        allGroup.forEach(group -> group.setTrainees(new ArrayList<>()));
        for (Group group : allGroup) {
            group.setTrainers(new ArrayList<>());
            group.setTrainees(new ArrayList<>());
        }
        Collections.shuffle(allTrainers);
        Collections.shuffle(allTrainees);
    }

}
