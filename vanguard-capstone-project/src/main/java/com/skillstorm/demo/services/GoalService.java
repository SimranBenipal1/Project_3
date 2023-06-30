package com.skillstorm.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Goal;
import com.skillstorm.demo.repositories.GoalRepository;

/**
 * The Class GoalService.
 */
@Service
public class GoalService {

    /** The goal repository. */
    private GoalRepository goalRepository;

    /**
     * Instantiates a new goal service.
     *
     * @param goalRepository the goal repository
     */
    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }
    
    /**
     * Gets the goals by sub.
     *
     * @param subValue the sub value
     * @return the goals by sub
     */
    public List<Goal> getGoalsBySub(String subValue) {
        return goalRepository.findBySub(subValue);
    }

    /**
     * Gets the goal by id.
     *
     * @param goalId the goal id
     * @return the goal by id
     */
    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    /**
     * Creates the goal.
     *
     * @param goal the goal
     * @return the goal
     */
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    /**
     * Update goal.
     *
     * @param goal the goal
     * @return the goal
     */
    public Goal updateGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    /**
     * Delete goal.
     *
     * @param goalId the goal id
     */
    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }
}
