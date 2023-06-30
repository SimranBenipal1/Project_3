package com.skillstorm.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Goal;

/**
 * The Interface GoalRepository.
 */
@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    
    /**
     * Find by sub.
     *
     * @param subValue the sub value
     * @return the list
     */
    List<Goal> findBySub(String subValue);
}
