package com.skillstorm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skillstorm.demo.models.Goal;
import com.skillstorm.demo.services.GoalService;

@RestController
@RequestMapping("/goals")
@CrossOrigin
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long goalId) {
        Goal goal = goalService.getGoalById(goalId);
        if (goal != null) {
            return new ResponseEntity<>(goal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/sub/{subValue}")
    public ResponseEntity<List<Goal>> getGoalsBySub(@PathVariable String subValue) {
        List<Goal> goals = goalService.getGoalsBySub(subValue);
        if (!goals.isEmpty()) {
            return new ResponseEntity<>(goals, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal createdGoal = goalService.createGoal(goal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

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
