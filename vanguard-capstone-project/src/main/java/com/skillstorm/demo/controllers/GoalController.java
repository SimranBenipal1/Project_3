package com.skillstorm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.demo.models.Goal;
import com.skillstorm.demo.services.GoalService;

/**
 * The Class GoalController.
 */
@RestController
@RequestMapping("/goals")
@CrossOrigin
public class GoalController {

    /** The goal service. */
    private GoalService goalService;

    /**
     * Instantiates a new goal controller.
     *
     * @param goalService the goal service
     */
    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    /**
     * Gets the goal by id.
     *
     * @param goalId the goal id
     * @return the goal by id
     */
    @GetMapping("/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long goalId) {
        Goal goal = goalService.getGoalById(goalId);
        if (goal != null) {
            return new ResponseEntity<>(goal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Gets the goals by sub.
     *
     * @param subValue the sub value
     * @return the goals by sub
     */
    @GetMapping("/sub/{subValue}")
    public ResponseEntity<List<Goal>> getGoalsBySub(@PathVariable String subValue) {
        List<Goal> goals = goalService.getGoalsBySub(subValue);
        if (!goals.isEmpty()) {
            return new ResponseEntity<>(goals, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates the goal.
     *
     * @param goal the goal
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal createdGoal = goalService.createGoal(goal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

    /**
     * Update goal.
     *
     * @param goalId the goal id
     * @param goal the goal
     * @return the response entity
     */
    @PutMapping("/{goalId}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long goalId, @RequestBody Goal goal) {
        Goal existingGoal = goalService.getGoalById(goalId);
        if (existingGoal != null) {
            goal.setId(goalId);
            Goal updatedGoal = goalService.updateGoal(goal);
            return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete goal.
     *
     * @param goalId the goal id
     * @return the response entity
     */
    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long goalId) {
        Goal existingGoal = goalService.getGoalById(goalId);
        if (existingGoal != null) {
            goalService.deleteGoal(goalId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
