package com.example.demo.service.impl;

import com.example.demo.beans.Group;
import com.example.demo.beans.Trainee;
import com.example.demo.beans.Trainer;
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
    public List<Group> AtuoGroup() {
        List<Group> allGroup = groupRepository.findAll();
        List<Trainee> allTrainees = traineeRepository.findAll();
        List<Trainer> allTrainers = trainerRepository.findAll();

        shuffleAllLists(allGroup, allTrainees, allTrainers);

        int groupSize = (int)Math.floor(allTrainees.size() / 2.0);

        for (int i = 0; i < allTrainees.size(); i++) {
            allGroup.get(i % groupSize).getTrainees().add(allTrainees.get(i));
            allTrainees.get(i).setGrouped(true);
            traineeRepository.save(allTrainees.get(i));
        }
        for (int i = 0; i < allTrainers.size(); i++) {
            allGroup.get(i % groupSize).getTrainers().add(allTrainers.get(i));
            allTrainers.get(i).setGrouped(true);
            trainerRepository.save(allTrainers.get(i));
        }
        for(Group group : allGroup) {
            groupRepository.save(group);
        }

        return groupRepository.findAll();
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
