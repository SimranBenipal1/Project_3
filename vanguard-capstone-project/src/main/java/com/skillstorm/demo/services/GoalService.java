package com.skillstorm.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Goal;
import com.skillstorm.demo.repositories.GoalRepository;

@Service
public class GoalService {

    private GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }
    
    public List<Goal> getGoalsBySub(String subValue) {
        return goalRepository.findBySub(subValue);
    }

    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal updateGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }
}
