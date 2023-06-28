package com.skillstorm.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findBySub(String subValue);
}
